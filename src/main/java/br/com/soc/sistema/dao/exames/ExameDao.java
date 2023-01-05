package br.com.soc.sistema.dao.exames;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameVo;

public class ExameDao extends Dao {

	private  static  final String NAO_FOI_POSSIVEL_EXCLUIR_O_EXAME = "Não foi possivel excluir o exame, já possui relacionamento com uma consulta.";


	public void insertExame(ExameVo exameVo){
		StringBuilder query = new StringBuilder("INSERT INTO exame (nm_exame) values (?)");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString())){
			
			int i=1;
			ps.setString(i++, exameVo.getNome());
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ExameVo> findAllExames(){
		StringBuilder query = new StringBuilder("SELECT codigo_exame id, nm_exame nome FROM exame");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery()){
			
			ExameVo vo =  null;
			List<ExameVo> exames = new ArrayList<>();
			while (rs.next()) {
				vo = new ExameVo();
				vo.setCodigoExame(rs.getString("id"));
				vo.setNome(rs.getString("nome"));	
				
				exames.add(vo);
			}
			return exames;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public List<ExameVo> findAllByNome(String nome){
		StringBuilder query = new StringBuilder("SELECT codigo_exame id, nm_exame nome FROM exame ")
								.append("WHERE lower(nm_exame) like lower(?)");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setString(i, "%"+nome+"%");
			
			try(ResultSet rs = ps.executeQuery()
			){
				ExameVo vo =  null;
				List<ExameVo> exames = new ArrayList<>();
				
				while (rs.next()) {
					vo = new ExameVo();
					vo.setCodigoExame(rs.getString("id"));
					vo.setNome(rs.getString("nome"));	
					
					exames.add(vo);
				}
				return exames;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public ExameVo findByCodigo(Integer codigo){
		StringBuilder query = new StringBuilder("SELECT codigo_exame id, nm_exame nome FROM exame ")
								.append("WHERE codigo_exame = ?");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()
			){
				ExameVo vo =  null;
				
				while (rs.next()) {
					vo = new ExameVo();
					vo.setCodigoExame(rs.getString("id"));
					vo.setNome(rs.getString("nome"));	
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}

	public void update(ExameVo exameVo){

		StringBuilder query = new StringBuilder("UPDATE exame SET (nm_exame) = ? WHERE codigo_exame = ?");
		try(
				Connection con = getConexao();
				PreparedStatement  ps = con.prepareStatement(query.toString())
		){
			int i=1;
			ps.setString(i++, exameVo.getNome());
			ps.setInt(i++, Integer.parseInt((exameVo.getCodigoExame())));
			ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluirExame(Integer codigo){
		StringBuilder query = new StringBuilder("DELETE FROM exame WHERE codigo_exame = ?");
		try (
				Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString())
		) {
			int i = 1;
			ps.setInt(i++, codigo);
			ps.executeUpdate();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new BusinessException(NAO_FOI_POSSIVEL_EXCLUIR_O_EXAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}