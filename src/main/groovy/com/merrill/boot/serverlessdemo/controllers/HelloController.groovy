package com.merrill.boot.serverlessdemo.controllers

import com.merrill.boot.serverlessdemo.dto.Response
import com.merrill.boot.serverlessdemo.support.rest.RestApi
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestApi
class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Response> 'default'() {
		ResponseEntity.ok().body(
		new Response(true, "Hello Default !"))
	}
	@RequestMapping(value = "/world", method = RequestMethod.GET)
	@ResponseBody
	public Response hello() {
		new Response(true, "Hello World !")
	}
}
