package com.estoque.lojadeinstrumento.excessao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class LojaInstrumentosTratamentoExcessao extends ResponseEntityExceptionHandler {

	private static final String CONSTANT_VALIDATION_LENGTH = "Length";
	private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Erro> erros = gerarListaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);

	}

	private List<Erro> gerarListaDeErros(BindingResult bindingResult) {
		List<Erro> erros = new ArrayList<Erro>();

		bindingResult.getFieldErrors().forEach(fieldError -> {
			String msgUsuario = tratarMensagemDeErroParaUsuario(fieldError);
			String msgDesenvolvedor = fieldError.toString();
			erros.add(new Erro(msgUsuario, msgDesenvolvedor));
		});

		return erros;
	}

	private String tratarMensagemDeErroParaUsuario(FieldError fieldError) {
		if (fieldError.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
			return fieldError.getDefaultMessage().concat(" é obrigatório.");
		}
		if (fieldError.getCode().equals(CONSTANT_VALIDATION_LENGTH)) {
			return fieldError.getDefaultMessage().concat(String.format(" deve conter de %s a %s caracteres",
					fieldError.getArguments()[2], fieldError.getArguments()[1]));
		}
		return fieldError.toString();
	}

}
