package lambda.unitarios.lambda.lambda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import lambda.unitarios.lambda.controller.UsuarioController;
import lambda.unitarios.lambda.dto.req.UsuarioReqDto;
import lambda.unitarios.lambda.dto.res.UsuarioResDto;

@Component
public class UsuarioLambdaHandler implements RequestHandler<UsuarioReqDto, UsuarioResDto>  {
     @Autowired
    private UsuarioController usuarioController;

    @Override
    public UsuarioResDto handleRequest(UsuarioReqDto usuarioReqDto, Context context) {
        return usuarioController.createUsuario(usuarioReqDto).getBody();
    }

    
}
