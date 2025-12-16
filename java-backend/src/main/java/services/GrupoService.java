package services;

import database.models.Item;
import database.models.UsrMinimo2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "/grupo", description = "Servicios grupo")
@Path("/grupo")
public class GrupoService {
    private static Map<String, List<UsrMinimo2>> mapaGrupos = new HashMap<String, List<UsrMinimo2>>();

    static {
        mapaGrupos.put("grupo1", List.of(
                new UsrMinimo2("usuario1", "https://cdn.pixabay.com/photo/2017/07/11/15/51/kermit-2493979_1280.png", 100, "grupo1"),
                new UsrMinimo2("usuario2", "https://cdn.pixabay.com/collection/thumbnail/2025/11/04/untitled_design-640.png", 150, "grupo1")
        ));
        mapaGrupos.put("grupo2", List.of(
                new UsrMinimo2("usuario3", "https://cdn.pixabay.com/photo/2024/11/21/17/06/xmas-9214261_1280.png", 200, "grupo2"),
                new UsrMinimo2("usuario4", "https://cdn.pixabay.com/photo/2023/12/13/17/47/christmas-tree-8447387_1280.jpg", 300, "grupo2"),
                new UsrMinimo2("usuario6", "https://cdn.pixabay.com/photo/2023/12/14/20/24/christmas-balls-8449616_1280.jpg", 251, "grupo2")

        ));
        mapaGrupos.put("grupo3", List.of(
                new UsrMinimo2("usuario5", "https://cdn.pixabay.com/photo/2022/11/10/20/29/snowman-7583640_1280.jpg", 200, "grupo3")
        ));
    }

    @GET
    @Path("/{groupname}")
    @ApiOperation(value = "Obtener todos los miembros del grupo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsrMinimo2.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Item o usuario no encontrado", response = String.class)

    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(@PathParam("groupname") String groupname) {
            List<UsrMinimo2> listUsrMinimo2 = mapaGrupos.get(groupname);
            if (listUsrMinimo2 != null) {
                GenericEntity<List<UsrMinimo2>> entity = new GenericEntity<List<UsrMinimo2>>(listUsrMinimo2) {
                };
                return Response.status(200).entity(entity).build();
            }
            else{
                    return Response.status(Response.Status.NOT_FOUND)
                            .entity("{error: 'Grupo no encontrado'}")
                            .build();
            }
    }
    @GET
    @Path("/user/{userId}/team")
    @ApiOperation(value = "Obtener el equipo de un usuario específico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = UsrMinimo2.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Usuario no encontrado en ningún grupo", response = String.class)
    })
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTeamFromUser(@PathParam("userId") String userId) {

        List<UsrMinimo2> miembrosEquipo = null;
        String nombreEquipo = null;
        for (Map.Entry<String, List<UsrMinimo2>> entry : mapaGrupos.entrySet()) {
            List<UsrMinimo2> listaUsuarios = entry.getValue();
            for (UsrMinimo2 u : listaUsuarios) {
                if (u.getName().equals(userId)) {
                    miembrosEquipo = listaUsuarios;
                    nombreEquipo = entry.getKey();
                    break;
                }
            }
            if (miembrosEquipo != null){
                break;
            }
        }

        if (miembrosEquipo != null) {
            GenericEntity<List<UsrMinimo2>> entity = new GenericEntity<List<UsrMinimo2>>(miembrosEquipo) {};
            return Response.status(200).entity(entity).build();
        } else {
            return Response.status(404).entity("{error: 'Usuario no tiene equipo'}").build();
        }
    }
}
