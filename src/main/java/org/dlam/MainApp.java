package org.dlam;
import org.eclipse.jetty.server.Server;



public class MainApp {


    public static void main(String[] args)  {

        try {
            JettyServer jettyServer = new JettyServer();

            Server server = jettyServer.setupJettyServer();
            server.start();






            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    System.out.println("Shutting down the application...");
                    server.stop();
                    System.out.println("Done, exit.");
                } catch (Exception e) {
                    e.printStackTrace();
                    //Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, e);
                }
            }));

            System.out.println(
                    String.format("Application started.%nStop the application using CTRL+C"));

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

            // alternative
            // Thread.sleep(Long.MAX_VALUE);       // sleep forever...
            // Thread.sleep(Integer.MAX_VALUE);    // sleep around 60+ years

        } catch (InterruptedException ex ) {
            ex.printStackTrace();
            //Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception excep) {
            excep.printStackTrace();
            //Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
