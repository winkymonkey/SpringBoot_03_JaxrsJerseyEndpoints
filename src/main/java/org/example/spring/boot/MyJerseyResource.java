package org.example.spring.boot;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.util.StringUtils;


@Path("/v1/main")
@Produces(MediaType.APPLICATION_JSON)
public class MyJerseyResource {
	
	private static final String ERR_STR = "Something went wrong!! Please try again after sometime.";
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint0
	 * ----------------------------------------------------
	 */
	@GET
	@Path("/endpoint0")
	public String endpoint0() {
		return "Success String0";
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint1
	 * ----------------------------------------------------
	 */
	@GET
	@Path("/endpoint1")
	public Response endpoint1() {
		Response response;
		try {
			response = Response.status(Status.OK).entity("Success String1").header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint2/1234
	 * ----------------------------------------------------
	 */
	@GET
	@Path("/endpoint2/{id}")
	public Response endpoint2(@PathParam("id") String id) {
		Response response;
		try {
			if(null==id || id.length()!=4)
				response = Response.status(Status.BAD_REQUEST).entity("PathParam cannot be null/blank and length must be 4").header("header1", "value1").build();
			else
				response = Response.status(Status.OK).entity("Success String2:: PathParam="+id).header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint3?id=5678
	 * ----------------------------------------------------
	 */
	@GET
	@Path("/endpoint3")
	public Response endpoint3(@QueryParam("id") String id) {
		Response response;
		try {
			if(null==id || id.length()!=4)
				response = Response.status(Status.BAD_REQUEST).entity("QueryParam cannot be null/blank and length must be 4").header("header1", "value1").build();
			else
				response = Response.status(Status.OK).entity("Success String3 :: QueryParam="+id).header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint4
	 * Send this JSON in request body {"name":"TOM", "id":"123"}
	 * ----------------------------------------------------
	 */
	@POST
	@Path("/endpoint4")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response endpoint4(Student student) {
		Response response;
		try {
			if(null==student)
				response = Response.status(Status.BAD_REQUEST).entity("Request body cannot be blank").header("header1", "value1").build();
			else
				response = Response.status(Status.OK).entity("Success String4 :: StudentObject="+student).header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint5
	 * Send this JSON in request {"name":"TOM", "id":"123"}
	 * ----------------------------------------------------
	 */
	@POST
	@Path("/endpoint5")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent_sendStudentInBody(Student student) {
		Response response;
		try {
			if(null==student)
				response = Response.status(Status.BAD_REQUEST).entity("Request body cannot be blank").header("header1", "value1").build();
			else
				response = Response.status(Status.OK).entity(student).header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
	
	/**
	 * ----------------------------------------------------
	 * URL: http://localhost:8080/v1/main/endpoint6
	 * ----------------------------------------------------
	 */
	@GET
	@Path("/endpoint6")
	@Produces(MediaType.APPLICATION_JSON)
	public Response endpoint6(@HeaderParam("token") String token) {
		Response response;
		String tokenReference = "";
		try {
			try(BufferedReader objReader = new BufferedReader(new FileReader("token.txt"))) {
				while ((tokenReference = objReader.readLine()) != null) {
					break;
				}
				if(StringUtils.isEmpty(tokenReference))
					throw new RuntimeException("Please validate token.txt file");
			}
			catch(Exception ex) {
				throw ex;
			}
			
			if(StringUtils.isEmpty(token))
				response = Response.status(Status.UNAUTHORIZED).entity("token in header cannot be null/blank").header("header1", "value1").build();
			else if(!token.equals(tokenReference))
				response = Response.status(Status.UNAUTHORIZED).entity("token is invalid; Access Denied").header("header1", "value1").build();
			else
				response = Response.status(Status.OK).entity("Success String6").header("header1", "value1").build();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			CustomError err = new CustomError(ERR_STR, ex.toString());
			response = Response.status(Status.INTERNAL_SERVER_ERROR).entity(err).header("header1", "value1").build();
		}
		return response;
	}
	
}
