package si.fri.rso.samples.imagecatalog.api.v1.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import si.fri.rso.samples.imagecatalog.lib.KomentarMetadata;
import si.fri.rso.samples.imagecatalog.services.beans.KomentarMetadataBean;

@ApplicationScoped
@Path("/komentar")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@CrossOrigin(allowOrigin = "*")
public class KomentarMetadataResource {

    private Logger log = Logger.getLogger(KomentarMetadataResource.class.getName());

    @Inject
    private KomentarMetadataBean komentarMetadataBean;

    @Context
    protected UriInfo uriInfo;

    @GET
    public Response getKomentarMetadata() {

        List<KomentarMetadata> komentarMetadata = komentarMetadataBean.getKomentarMetadataFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(komentarMetadata).build();
    }


    @GET
    @Path("/{KomentarId}")
    public Response getKomentarMetadata(@PathParam("KomentarId") Integer komentarMetadataId) {

        KomentarMetadata komentarMetadata = komentarMetadataBean.getKomentarMetadata(komentarMetadataId);

        if (komentarMetadata == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(komentarMetadata).build();
    }

    @POST
    public Response createKomentarMetadata(KomentarMetadata komentarMetadata) {

        if ((komentarMetadata.getVsebina() == null)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            komentarMetadata = komentarMetadataBean.createImageMetadata(komentarMetadata);
        }

        return Response.status(Response.Status.OK).entity(komentarMetadata).build();

    }

//    @PUT
//    @Path("{imageMetadataId}")
//    public Response putImageMetadata(@PathParam("imageMetadataId") Integer imageMetadataId,
//                                     KomentarMetadata komentarMetadata) {
//
//        komentarMetadata = komentarMetadataBean.putImageMetadata(imageMetadataId, komentarMetadata);
//
//        if (komentarMetadata == null) {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//
//        return Response.status(Response.Status.NOT_MODIFIED).build();
//
//    }
//
//    @DELETE
//    @Path("{imageMetadataId}")
//    public Response deleteImageMetadata(@PathParam("imageMetadataId") Integer imageMetadataId) {
//
//        boolean deleted = komentarMetadataBean.deleteImageMetadata(imageMetadataId);
//
//        if (deleted) {
//            return Response.status(Response.Status.NO_CONTENT).build();
//        }
//        else {
//            return Response.status(Response.Status.NOT_FOUND).build();
//        }
//    }
}
