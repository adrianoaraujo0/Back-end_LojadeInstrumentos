package com.estoque.lojadeinstrumento.excessao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class LojaInstrumentosTratamentoExcessao extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		gerarListaDeErros(ex.getBindingResult());
		
		return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}

	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<Erro>();
		
		bindingResult.getFieldErrors().forEach(fieldErro -> {
			String msgUsuario = fieldErro.getDefaultMessage();
			String msgDesenvolvedor = fieldErro.toString();
			erros.add(new Erro(msgUsuario, msgDesenvolvedor));
		});
		
		return erros;
	}
	
}
