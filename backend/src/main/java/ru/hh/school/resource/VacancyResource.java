package ru.hh.school.resource;

import ru.hh.school.Dto.AddVacancyDto;
import ru.hh.school.Dto.CommentDto;
import ru.hh.school.Dto.VacancyFavoriteDto;
import ru.hh.school.service.VacancyService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/vacancy")
public class VacancyResource {
    VacancyService vacancyService;

    public VacancyResource(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GET
    @Path("/favorites")
    @Produces("application/json")
    public Response getFavoriteVacancies() {
        List<VacancyFavoriteDto> vacancies = vacancyService.getFavoriteVacancies();
        return Response.ok().entity(vacancies).build();
    }

    @POST
    @Path("/favorites")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addVacancyToFavorite(
            AddVacancyDto vacancy
    ) {
        vacancyService.addOrUpdateVacancyInFavorite(vacancy.getId(), vacancy.getComment());
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/favorites/{vacancy_id}")
    @Produces("application/json")
    public Response getFavoriteVacancy(@PathParam("vacancy_id") Integer vacancyId) {
        VacancyFavoriteDto vacancy = vacancyService.getVacancyById(vacancyId);
        return Response.ok().entity(vacancy).build();
    }

    @POST
    @Path("/favorites/{vacancy_id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateVacancyComment(@PathParam("vacancy_id") Integer id, CommentDto comment) {
        vacancyService.updateVacancyComment(id, comment.getComment());
        return Response.ok().build();
    }

    @DELETE
    @Path("/favorites/{vacancy_id}")
    @Produces("application/json")
    public Response deleteFavoriteVacancy(@PathParam("vacancy_id") Integer vacancyId) {
        vacancyService.deleteVacancyById(vacancyId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
