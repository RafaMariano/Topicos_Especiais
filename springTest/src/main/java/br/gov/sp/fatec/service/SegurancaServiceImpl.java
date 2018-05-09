package br.gov.sp.fatec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.model.Usuario;
import br.gov.sp.fatec.repository.UsuarioRepository;

@Service("segurancaService")
public class SegurancaServiceImpl implements SegurancaService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	@Transactional
	public void exemploTransacao() {
		// Cria usuario
		Usuario usuario1 = new Usuario();
		usuario1.setNome("Pedro");
		usuario1.setSenha("senha");
		usuarioRepo.save(usuario1);
		// Gera erro, pois nome e senha sao obrigatorios
		Usuario usuario2 = new Usuario();
		usuarioRepo.save(usuario2);		
	}

	/**
	 * @param usuarioRepo the usuarioRepo to set
	 */
	public void setUsuarioRepo(UsuarioRepository usuarioRepo) {
		this.usuarioRepo = usuarioRepo;
	}

}
