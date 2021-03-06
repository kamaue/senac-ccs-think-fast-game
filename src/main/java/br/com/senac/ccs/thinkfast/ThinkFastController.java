package br.com.senac.ccs.thinkfast;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet( urlPatterns = { "/thinkfast" },
             asyncSupported = true )
public class ThinkFastController extends HttpServlet {

    private ThinkFastGame game;

    @Override
    public void init( ServletConfig config ) throws ServletException {
        super.init( config );
        WebApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext( config.getServletContext() );
        this.game = applicationContext.getBean( ThinkFastGame.class );
    }

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {
        final String id = req.getSession().getId();
        final String action = req.getParameter( "action" );
        if ( "play".equals( action ) ) {
            AsyncContext startAsync = req.startAsync();
            Screen screen = new WebScreen(startAsync);
            game.play( id, req.getParameter( "participant" ), screen );
        }
        else if ( "bind".equals( action ) ) {
            AsyncContext startAsync = req.startAsync();
            Screen screen = new WebScreen(startAsync);
            game.bind( id, screen );
        }
        else if ( "answer".equals( action ) ) {
            game.answer( id, req.getParameter( "answer" ) );
        }
    }
}