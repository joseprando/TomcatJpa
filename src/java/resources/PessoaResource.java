package resources;

import daos.PessoaDAO;
import entidades.Pessoa;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("pessoas")
public class PessoaResource {
    
    private PessoaDAO dao;
    
    public PessoaResource() {
        dao = new PessoaDAO();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Pessoa> list() {
        List<Pessoa> lista = dao.list();
        if (lista == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return lista;
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pessoa find(@PathParam("id") Integer id) {
        Pessoa p = dao.find(id);
        if (p == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return p;
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response persist(Pessoa p) {
        dao.persist(p);
        return Response.created(URI.create("/" + p.getId())).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void merge(@PathParam("id") Integer id, Pessoa p) {
        Pessoa update = dao.find(id);
        if (update == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        dao.merge(p);
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        Pessoa remove = dao.find(id);
        if (remove != null) {
            dao.remove(remove);
        }
        return Response.noContent().build();
    }
}
