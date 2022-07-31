package org.dlam;


import org.dlam.rest.MyResource;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.jersey.servlet.ServletContainer;

public class JettyServer {
    public  final String BASE_URI = "http://localhost:8080/";


    public  Server setupJettyServer() {

        //this is for the rest interface
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/rest");
        // scan packages
        final ResourceConfig config = new ResourceConfig(MyResource.class);
        ServletHolder holder = new ServletHolder(new ServletContainer(config));
        context.addServlet(holder, "/*");

        //this is for serving static files.  locates static files under src/main/resources/webapp directory
        java.net.URL warUrl = this.getClass().getClassLoader().getResource("webapp");
        String warUrlString = warUrl.toExternalForm();
        System.out.println(warUrlString);
        WebAppContext context2 = new WebAppContext();
        context2.setResourceBase(warUrlString);
        context2.setContextPath("/files");

        HandlerList hl = new HandlerList();
        hl.addHandler(context);
        hl.addHandler(context2);


        Server server = new Server(8080);
        server.setHandler(hl);

        // Start Jetty Server
//        Server server = JettyHttpContainerFactory.createServer(java.net.URI.create(BASE_URI), config);


        return server;
    }
}
