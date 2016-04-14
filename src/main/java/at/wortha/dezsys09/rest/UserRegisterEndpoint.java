package at.wortha.dezsys09.rest;

import at.wortha.dezsys09.db.User;
import at.wortha.dezsys09.db.UserRepository;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.TransactionSystemException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Mapping for path {@code /register}
 *
 * @author Simon Wortha 5BHIT
 * @version 20160311.1
 */
@Named
@Path("/register")
@Produces({MediaType.APPLICATION_JSON})
public class UserRegisterEndpoint {

    @Inject
    private UserRepository userRepository;

    /**
     * Registers a new user
     *
     * @param user the user which should be registered
     * @return response
     */
    @POST
    public Response post(User user) {
        try {
            if (!userRepository.exists(user.getEmail())) {
                User savedUser = this.userRepository.save(user);
                return Response.status(Response.Status.CREATED).entity("User " + savedUser.getEmail() + " saved!").type(MediaType.TEXT_PLAIN).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("User " + user.getEmail() + " already exists!").type(MediaType.TEXT_PLAIN).build();
            }
        } catch (TransactionSystemException | InvalidDataAccessApiUsageException ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing parameters!").type(MediaType.TEXT_PLAIN).build();
        }
    }
}