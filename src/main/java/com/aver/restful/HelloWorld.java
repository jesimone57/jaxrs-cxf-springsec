package com.aver.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

@Component
@Path("/")
public class HelloWorld {

		@GET
		@Produces("text/plain")
		@Path("/hello/{name}/")
		public String helloWorld(@PathParam("name") String name) {
			return "Hello "+name;
		}
		
		
		@GET
		@Produces("text/plain")
		@Path("/helloname/")
		public String hello(@QueryParam("name") String name) {
			if (name == null) {
				name = "World";
			}
			return "Hello "+name;
		}

}
