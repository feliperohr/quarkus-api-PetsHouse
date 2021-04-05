package controller.task;

import dto.task.TaskDTO;
import service.task.TaskService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/api/task")
public class TaskResource {

    @Inject
    TaskService service;

    @GET
    public Response getAll() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getTaskById(@PathParam("id") long id) {
        return Response.ok(service.findTaskById(id)).build();
    }

    @GET
    @Path("/filter/{filter}")
    public Response getAllTaskByFilter(@PathParam("filter") String filter){
        return Response.ok(service.findAllTask(filter)).build();
    }

    @POST
    public Response create(@Valid TaskDTO dto) {
        service.persistTask(dto);
        return Response.ok().build();
    }

}
