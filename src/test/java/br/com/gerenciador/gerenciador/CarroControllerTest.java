package br.com.gerenciador.gerenciador;

import br.com.gerenciador.gerenciador.entity.Carro;
import br.com.gerenciador.gerenciador.repository.CarroRepository;
import br.com.gerenciador.gerenciador.service.CarroService;
import br.com.gerenciador.gerenciador.util.TestUtil;
import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)

class CarroControllerTest {

	private static final String CARRO_RESOURCE_URL = "/carros";
	private static final String CARRO_RESOURCE_URL_ID = CARRO_RESOURCE_URL + "/{idCarro}";

	@Autowired
	private MockMvc carroController;

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private CarroService carroService;

	@Test
	void salvarCarro_deveTersucesso_validarDados() throws Exception {
		Carro carro = criarCarro();

		carroController.perform(post(CARRO_RESOURCE_URL).contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(carro))).andExpect(status().isCreated());
	}

	@Test
	void consultarCarro_deveTersucessoAoBuscarCarroPorMaecoOuModelo_validarDados() throws Exception {
		Carro carro = criarCarro();

		Carro carro1 = criarCarro();
		carro1.setMarca("toyota");
		carro1.setModelo("corolla");

		carroService.salvarCarro(carro);

		carroService.salvarCarro(carro1);

		List<Carro> carros = carroService.pesquisarCarroPorMarcaOuModelo("ota", null);

		Carro car = carros.get(0);

		assertThat(car.getMarca()).isEqualTo("toyota");
	}

	@Test
	void exclurCarro_deveTersucessoAoExcluirCarro() throws Exception {
		Carro carro = criarCarro();

		Carro carroSalvo = carroService.salvarCarro(carro);

		carroController.perform(delete(CARRO_RESOURCE_URL_ID, carroSalvo.getId()).contentType(MediaType.APPLICATION_JSON)
				.content(TestUtil.convertObjectToJsonBytes(carro))).andExpect(status().isNoContent());
	}

	@Test
	void editarCarro_deveEditarCarro() throws Exception {
		Carro carro = criarCarro();

		Carro carroSalvo = carroService.salvarCarro(carro);

		carroSalvo.setModelo("toyota");

		carroController.perform(put(CARRO_RESOURCE_URL_ID, carroSalvo.getId())
						.contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(carroSalvo)))
				.andExpect(status().isOk());

		assertThat(carroSalvo.getModelo()).isEqualTo("toyota");

	}


	public Carro criarCarro() {

		Carro carro = new Carro();
		carro.setId(1L);
		carro.setMarca("Fiat");
		carro.setModelo("Uno");
		carro.setAno("2008");
		carro.setKilometragem("87mil");
		carro.setVendido(false);


		return carro;

	}



}
