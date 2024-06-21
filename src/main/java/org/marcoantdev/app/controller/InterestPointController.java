package org.marcoantdev.app.controller;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.marcoantdev.app.dto.InterestPointDTO;
import org.marcoantdev.app.service.InterestPointService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Tag(name = "Interest Point Controller", description = "Routes responsible for managing points of interest.")
@Path("/interest-points")
public class InterestPointController {
    
    @Inject InterestPointService interestPointService;
    
    @GET
    @Operation(summary = "Get all interest points.", description = "Get all interest points.")
    public Response getAllInterestPoints() {
        return Response.ok(interestPointService.getAllInterestPoints()).build();
    }

    @POST
    @Operation(summary = "Create a new interest point.", description = "Create a new interest point.")
    public Response createInterestPoint(InterestPointDTO body) {
        return Response.ok(interestPointService.createInterestPoint(body)).build();
    }
}
