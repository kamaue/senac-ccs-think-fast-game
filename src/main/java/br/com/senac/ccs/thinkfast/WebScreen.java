package br.com.senac.ccs.thinkfast;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.AsyncContext;


public class WebScreen implements Screen {

    private AsyncContext asyncContext;

    public WebScreen( AsyncContext asyncContext ) {
        this.asyncContext = asyncContext;
    }
    
    @Override
    public void show( final Result result ) {
        if(asyncContext != null) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                final String json = mapper.writeValueAsString( result );
                asyncContext.getResponse().getWriter().write( json );
                asyncContext.complete();
                asyncContext = null;
            }
            catch ( IOException ex ) {
                
            }
        }
    }
    
}
