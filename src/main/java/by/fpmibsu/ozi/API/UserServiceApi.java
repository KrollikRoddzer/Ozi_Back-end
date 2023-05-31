package by.fpmibsu.ozi.API;

import by.fpmibsu.ozi.dao.DaoException;
import by.fpmibsu.ozi.dao.UserDao;
import by.fpmibsu.ozi.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.oas.annotations.parameters.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServiceApi
{
    private static final UserDao userDao = new UserDao();
    @GET
    @Path("/{id}")
    @ApiOperation(value = "Gets a user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response getUserById(
            @ApiParam(value = "User ID", required = true) @PathParam("id") Integer id) {
        try {
            User user = userDao.findById(id);
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @ApiOperation(value = "Gets all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response getAllUsers() {
        try {
            List<User> user = userDao.findAll();
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation(value =  "Deletes User by id.")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response deleteUserById(@ApiParam(value = "User ID", required = true) @PathParam("id") Integer id) {
        try {
            User user = userDao.findById(id);
            userDao.delete(user);
            return Objects.equals(user, "null") ? Response.status(Response.Status.NOT_FOUND).build() :
                    Response.ok(user).build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    @ApiOperation(value = "Creates user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response postUser(@ApiParam(value="User", required = true) @RequestBody User user) {
        try {
            boolean res = userDao.create(user);
            if (! res)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            return Response.ok("User successfully created.").build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @ApiOperation(value = "updates users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 404, message = "User not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public Response putUser(@ApiParam(value="User", required = true) @RequestBody User user) {
        try {
            User res = userDao.update(user);
            if (res == null)
            {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            return Response.ok("User successfully updated.").build();
        } catch (DaoException | InterruptedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
