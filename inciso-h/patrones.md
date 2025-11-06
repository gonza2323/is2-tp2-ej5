## Patrón creacional (Builder)

Un ejemplo de patrón creacional utilizado es el patrón Builder. En el mismo, vamos construyendo un objeto paso a paso, utilizando un objecto auxiliar de tipo Builder, en lugar utilizar el constructor del objecto en cuestión.

Esto hace más clara la configuración que se le está dando al objeto. Además, si el objeto tiene combinaciones complejas de posibles argumentos para su construcción, este patrón evita tener que crear múltiples constructores para el mismo. La desventaja es que se pierde la detección de errores en tiempo de compilación, y los errores ocurren durante la ejecución si es que no se proveyeron todos los campos necesarios para la construcción del objeto.

Lo utilizamos en esta sección del código que genera algunos datos iniciales:

```java
@Transactional
protected void crearMecanicos() {
    mecanicoService.create(MecanicoCreateDto.builder()
            .legajo("123456")
            .nombre("Javier")
            .apellido("Perez")
            .usuario(UsuarioCreateDto.builder()
                    .email("pepeargento@gmail.com")
                    .clave("1234")
                    .confirmacionClave("1234")
                    .build())
            .build());
    }
```


## Patrón de comportamiento (Estrategia)

Se utilizó el patŕon estrategia para las consultas paginadas de recursos. En el patrón estrategia, en lugar de que un método o clase implemente una única estrategia para resolver un problema, el mismo pasa a recibir la estrategia como argumento (por ejemplo, las funciones de ordenar, pueden recibir un criterio que defina el orden de la colección, en lugar de asumirlo).

En nuestro caso, lo utilizamos en los repositorios JPA, para obtener resultados paginados. Aquí, el objeto Pageable representa la estrategia sobre cómo queremos paginar los resultados (nro. de página, tamaño de página, orden, etc.)

```java
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<E, ID> {
    Optional<E> findByIdAndEliminadoFalse(ID id);
    Page<E> findByEliminadoFalse(Pageable pageable); // buscar con estrategia
}
```

## Patrón estructural (Fachada)

El patrón fachada consiste en agregar una capa adicional al modelo de capas (controlado - servicio - persistencia), entre las capas controlador y servicio. Esto ayuda a coordinar diferentes servicios cuando tenemos un caso de uso complejo que involucra a muchos de los mismos, y el caso de uso no corresponde a ninguno en particular que pueda orquestar a los demás. En estos casos, es conveniente agregar una capa intermedia "fachada", que resuelva el caso de uso, y delegue sub tareas a los servicios individuales. Esto también reduce el acoplamiento entre servicios.

En nuestro proyecto, lo utilizamos para resolver una dependencia circular que existía entre las clases VehiculoService e HistorialArregloService. Al extraer el método de eliminarVehículo (que involucra también eliminar su historial de arreglos), y colocarlo en la fachada, removemos la dependencia circular. Ahora es la fachada la encargada de asegurarse de que cuando se elimina un vehículo, se eliminen también sus arreglos.

```java
@Service
@RequiredArgsConstructor
public class VehiculoFacade {
    private final VehiculoService vehiculoService;
    private final HistorialArregloService historialArregloService;

    @Transactional
    public void eliminarVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoService.delete(id);
        historialArregloService.deleteByVehiculo(vehiculo);
    }
}
```