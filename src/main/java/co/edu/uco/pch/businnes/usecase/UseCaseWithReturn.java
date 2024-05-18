package co.edu.uco.pch.businnes.usecase;

public interface UseCaseWithReturn <T, R> {
	
	R execute(T data);

}
