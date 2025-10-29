package ar.edu.uncuyo.dashboard.controller;

import ar.edu.uncuyo.dashboard.dto.IdentifiableDto;
import ar.edu.uncuyo.dashboard.error.BusinessException;
import ar.edu.uncuyo.dashboard.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;

public abstract class BaseController<
        ID extends Serializable,
        DetailDto extends IdentifiableDto<ID>,
        SummaryDto,
        CreateDto,
        UpdateDto extends IdentifiableDto<ID>,
        S extends BaseService<?, ID, ?, DetailDto, SummaryDto, CreateDto, UpdateDto, ?>> {

    protected final S service;
    protected final String resourceName;
    protected final String resourceNamePlural;
    protected final String listView;
    protected final String detailView;
    protected final String createView;
    protected final String editView;
    protected final String listUrl;

    protected BaseController(S service, String resourceName, String resourceNamePlural) {
        this.service = service;

        this.resourceName = resourceName.toLowerCase();
        this.resourceNamePlural = resourceNamePlural.toLowerCase();

        this.listView = resourceName + "/" + resourceName + "Lista";
        this.detailView = resourceName + "/" + resourceName + "Detalle";
        this.createView = resourceName + "/" + resourceName + "Alta";
        this.editView = resourceName + "/" + resourceName + "Edit";
        this.listUrl = "/" + resourceNamePlural;
    }

    @GetMapping("")
    public String list(Model model) {
        return prepareListView(model);
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable ID id) {
        return prepareDetailView(model, id);
    }

    @GetMapping("/alta")
    public String create(Model model, @ModelAttribute("form") CreateDto dto) {
        return prepareCreateFormView(model, dto);
    }

    @GetMapping("/{id}/edit")
    public String update(Model model, @PathVariable ID id) {
        return prepareEditFormView(model, id);
    }

    @PostMapping("/alta")
    public String create(Model model, @Valid @ModelAttribute("form") CreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return prepareCreateFormView(model, dto);

        try {
            preCreate(dto);
            DetailDto created = service.createAndReturnDto(dto);
            postCreate(dto, created);
            return "redirect:" + listUrl;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepareCreateFormView(model, dto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepareCreateFormView(model, dto);
        }
    }

    @PostMapping("/edit")
    public String update(Model model, @Valid @ModelAttribute("form") UpdateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return prepareEditFormView(model, dto);

        try {
            preUpdate(dto);
            DetailDto updated = service.updateAndReturnDto(dto);
            postUpdate(dto, updated);
            return "redirect:" + listUrl;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepareEditFormView(model, dto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepareEditFormView(model, dto);
        }
    }

    @PostMapping("/{id}/baja")
    public String delete(Model model, @PathVariable ID id) {
        try {
            preDelete(id);
            service.delete(id);
            postDelete(id);
            return "redirect:" + listUrl;
        } catch (BusinessException e) {
            model.addAttribute("msgError", e.getMessage());
            return prepareListView(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("msgError", "Error de sistema");
            return prepareListView(model);
        }
    }

    private String prepareListView(Model model) {
        preListView(model);
        Page<SummaryDto> items = service.findDtos(null);
        model.addAttribute(resourceNamePlural, items);
        postListView(model, items);
        return listView;
    }

    private String prepareDetailView(Model model, ID id) {
        preDetailView(model, id);
        DetailDto dto = service.findDto(id);
        model.addAttribute("form", dto);
        postDetailView(model, id, dto);
        return detailView;
    }

    private String prepareCreateFormView(Model model, CreateDto dto) {
        preCreateView(model);
        model.addAttribute("form", dto);
        postCreateView(model);
        return createView;
    }

    private String prepareEditFormView(Model model, UpdateDto dto) {
        preEditView(model);
        model.addAttribute("form", dto);
        postEditView(model);
        return editView;
    }

    private String prepareEditFormView(Model model, ID id) {
        DetailDto dto = service.findDto(id);
        preEditView(model);
        model.addAttribute("form", dto);
        postEditView(model);
        return editView;
    }


    // sobreescribir para agregar funcionalidad

    protected void preListView(Model model) {}
    protected void postListView(Model model, Page<SummaryDto> items) {}

    protected void preDetailView(Model model, ID id) {}
    protected void postDetailView(Model model, ID id, DetailDto dto) {}

    protected void preCreateView(Model model) {}
    protected void postCreateView(Model model) {}

    protected void preEditView(Model model) {}
    protected void postEditView(Model model) {}

    protected void preCreate(CreateDto createDto) {}
    protected void postCreate(CreateDto createDto, DetailDto created) {}

    protected void preUpdate(UpdateDto updateDto) {}
    protected void postUpdate(UpdateDto updateDto, DetailDto updated) {}

    protected void preDelete(ID id) {}
    protected void postDelete(ID id) {}
}

