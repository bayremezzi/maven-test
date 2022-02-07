package com.fr.allianz.rest.resource;


import com.fr.allianz.service.dto.AllianzEntityDto;
import com.fr.allianz.service.service.AllianzEntityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/allianz")
public class AllianzResource {

    @Autowired
    private AllianzEntityService allianzEntityService ;

    @GetMapping
    @ApiOperation("read an allianz Entity")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad parameter"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Prohibit access: insufficient role or scope"),
            @ApiResponse(code = 404, message = "allianz Entity not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity<List<AllianzEntityDto>> getAllianzEntityDto() {
        return ResponseEntity.ok(allianzEntityService.getEntities());
    }

    @PostMapping
    @ApiOperation("Create an allianz Entity")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad parameter"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Prohibit access: insufficient role or scope"),
            @ApiResponse(code = 404, message = "allianz Entity not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity createAllianzEntityDto(
        @ApiParam(value = "The entity to create") @RequestBody AllianzEntityDto allianzEntityDto) {
        allianzEntityService.addEntity(allianzEntityDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @ApiOperation("update an allianz Entity")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad parameter"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Prohibit access: insufficient role or scope"),
            @ApiResponse(code = 404, message = "allianz Entity not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity updateAllianzEntityDto(
            @ApiParam(value = "The entity to update") @RequestBody AllianzEntityDto allianzEntityDto) {
        allianzEntityService.updateEntity(allianzEntityDto);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("{keyId}")
    @ApiOperation("delete an allianz Entity")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad parameter"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Prohibit access: insufficient role or scope"),
            @ApiResponse(code = 404, message = "allianz Entity not found"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    public ResponseEntity deleteAllianzEntityDto(
            @ApiParam(value = "The entity to delete") @PathVariable long keyId) {
        allianzEntityService.deleteEntity(keyId);
        return ResponseEntity.ok().build();
    }
}
