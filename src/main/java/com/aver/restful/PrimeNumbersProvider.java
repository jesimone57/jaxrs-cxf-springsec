package com.aver.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;



@Produces("text/plain")
@Provider
public class PrimeNumbersProvider implements MessageBodyWriter<PrimeNumbers> {
	
    public long getSize(PrimeNumbers primes, Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return primes.getPrimeNumbers().toString().length();
    }

    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mt) {
        return PrimeNumbers.class.isAssignableFrom(type) || PrimeNumbers.class.isAssignableFrom(type);
    }

    public void writeTo(PrimeNumbers primes, Class<?> clazz, Type type, Annotation[] a, 
                        MediaType mt, MultivaluedMap<String, Object> headers, OutputStream os) 
        throws IOException {
        os.write(primes.getPrimeNumbers().toString().getBytes());
        
    }


}





