package ru.hh.school.resource;


import ru.hh.school.entity.Employer;
import ru.hh.school.service.EmployerService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/employer")
public class EmployerResource {
    EmployerService employerService;

    public EmployerResource(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GET
    @Produces("application/json")
    @Path("/favorites/{employer_id}")
    public Response getFavoriteEmployerById(
            @PathParam("employer_id") Integer employerId
    ) {
        Employer employer = employerService.getFavoriteEmployerById(employerId);
        if (employer == null) {
            return Response.status(404).build();
        }
        return Response.ok().entity(employer).build();
    }

}
