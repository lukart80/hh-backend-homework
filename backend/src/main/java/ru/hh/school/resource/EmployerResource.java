package ru.hh.school.resource;



import ru.hh.school.Dto.*;

import ru.hh.school.service.EmployerService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employer")
public class EmployerResource {
    EmployerService employerService;

    public EmployerResource(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GET
    @Path("")
    @Produces("application/json")
    public Response getEmployersFromApi(
            @DefaultValue("") @QueryParam("query") String query,
            @DefaultValue("0") @QueryParam("page") Integer page,
            @DefaultValue("20") @QueryParam("per_page") Integer per_page
    ) {
        List<EmployerDto> employers = employerService.getEmployersFromApi(query, page, per_page);
        return Response.ok().entity(employers).build();

    }

    @GET
    @Path("/{employer_id}")
    @Produces("application/json")
    public Response getEmployerFromApi(
            @PathParam("employer_id") Integer employerId
    ) {
        EmployerIdDto employer = employerService.getEmployerByIdFromApi(employerId);
        return Response.ok().entity(employer).build();
    }

    @GET
    @Path("/favorites")
    @Produces("application/json")
    public Response getEmployersInFavorite() {
        List<EmployerFavoriteDto> employers = employerService.getFavoriteEmployers();
        return Response.ok().entity(employers).build();
    }

    @POST
    @Path("/favorites")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addEmployerToFavorite(
            AddEmployerDto employerDto
    ) {
        employerService.addOrUpdateEmployerInFavorite(employerDto.getId(), employerDto.getComment());
        return Response.ok().build();
    }


    @GET
    @Produces("application/json")
    @Path("/favorites/{employer_id}")
    public Response getFavoriteEmployerById(
            @PathParam("employer_id") Integer employerId
    ) {
        EmployerFavoriteDto employer = employerService.getFavoriteEmployerEagerById(employerId);
        if (employer == null) {

            return Response.status(404).build();
        }
        return Response.ok().entity(employer).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/favorites/{employer_id}")
    public Response deleteFavoriteEmployer(
            @PathParam("employer_id") Integer employerId
    ) {
        employerService.deleteFavoriteEmployerById(employerId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Produces("application/json")
    @Path("/favorites/{employer_id}")
    @Consumes("application/json")
    public Response updateEmployerComment(
            CommentDto commentDto,
            @PathParam("employer_id") Integer employerId
    ) {
        employerService.updateEmployerComment(employerId, commentDto.getComment());
        return Response.ok("OK").build();
    }

    @POST
    @Produces("application/json")
    @Path("/favorites/{employer_id}/refresh")
    public Response refreshEmployerInFavorite(
            @PathParam("employer_id") Integer employerId
            ) {
        employerService.addOrUpdateEmployerInFavorite(employerId, "");
        return Response.ok("OK").build();
    }

}
