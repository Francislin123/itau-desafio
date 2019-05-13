package br.com.itau.desafioitau.resources.user;

import br.com.itau.desafioitau.core.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Api(value = "onlinestore", description = "Operations relating to the users")
@RestController
@RequestMapping(UserController.URI_USER)
public class UserController {

    public static final String URI_USER = "/user/";

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Send message for Users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful send message", response = ResponseEntity.class),
            @ApiResponse(code = 409, message = "Validation error"),
            @ApiResponse(code = 500, message = "Unhandled exception")})
    @RequestMapping(path = "/message-send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity sendMessageForCell(@Valid @RequestBody List<String> cells) {

        userService.sendMessageForCell(cells);

        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Send e-mail for Users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful send e-mail", response = ResponseEntity.class),
            @ApiResponse(code = 409, message = "Validation error"),
            @ApiResponse(code = 500, message = "Unhandled exception")})
    @RequestMapping(path = "/email-send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity sendEmail(@Valid @RequestBody List<String> emails) {

        userService.sendEmail(emails);

        return ResponseEntity.ok().build();
    }
}
