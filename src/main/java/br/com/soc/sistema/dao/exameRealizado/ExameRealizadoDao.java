package br.com.soc.sistema.dao.exameRealizado;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameRealizadoVo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExameRealizadoDao extends Dao {

    private  static  final String NAO_FOI_POSSIVEL_EXCLUIR_O_EXAME = "Não foi possivel excluir o exame, já possui relacionamento com uma consulta.";
    SimpleDateFormat formatterDate = new SimpleDateFormat("dd/MM/yyyy");
    public List<ExameRealizadoVo> findAllExamesRealizado(){
        StringBuilder query = new StringBuilder
                ("SELECT  ");
        try(
                Connection con = getConexao();
                PreparedStatement  ps = con.prepareStatement(query.toString());
                ResultSet rs = ps.executeQuery()){

            ExameRealizadoVo vo =  null;
            List<ExameRealizadoVo> examesRealizados = new ArrayList<>();


            while (rs.next()) {
                vo = new ExameRealizadoVo();
                vo.setCodigoExameRealizado(rs.getString("id"));
                vo.setNomeExame(rs.getString("exame"));
                vo.setNomeFuncionario(rs.getString("funcionario"));
                vo.setDataExameRealizado(formatterDate.format(rs.getDate("data")));

                examesRealizados.add(vo);
            }
            return examesRealizados;
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
    public void insertExameRealizado(ExameRealizadoVo exameRealizadoVo){
        StringBuilder query = new StringBuilder("INSERT INTO realizado (codigo_exame_realizado, codigo_funcionario_realizado, data_realizado) values (?)");
        try(
                Connection con = getConexao();
                PreparedStatement ps = con.prepareStatement(query.toString())){

            int i=1;
            ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getCodigoExame()));
            ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getCodigoFuncionario()));
            ps.setDate(i++, Date.valueOf(exameRealizadoVo.getDataExameRealizado()));
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<ExameRealizadoVo> findAllByNome(String nome){
        StringBuilder query = new StringBuilder("SELECT codigo_exame id, nm_exame nome FROM exame ")
                .append("WHERE lower(nm_exame) like lower(?)");

        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setString(i, "%"+nome+"%");

            try(ResultSet rs = ps.executeQuery()
            ){
                ExameRealizadoVo vo =  null;
                List<ExameRealizadoVo> examesRealizados = new ArrayList<>();

                while (rs.next()) {
                    vo = new ExameRealizadoVo();
                    vo.setCodigoExameRealizado(rs.getString("id"));
                    vo.setNomeExame(rs.getString("nomeExame"));
                    vo.setNomeFuncionario(rs.getString("nomeFuncionario"));
                    vo.setDataExameRealizado(formatterDate.format(rs.getDate("data")));

                    examesRealizados.add(vo);
                }
                return examesRealizados;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public ExameRealizadoVo findByCodigo(Integer codigo){
        StringBuilder query = new StringBuilder("SELECT codigo_exame id, nm_exame nome FROM exame ")
                .append("WHERE codigo_exame = ?");

        try(Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(query.toString())){
            int i = 1;

            ps.setInt(i, codigo);

            try(ResultSet rs = ps.executeQuery()
            ){
                ExameRealizadoVo vo =  null;

                while (rs.next()) {
                    vo = new ExameRealizadoVo();
                    vo.setCodigoExameRealizado(rs.getString("id"));
                    vo.setNomeExame(rs.getString("exame"));
                    vo.setNomeFuncionario(rs.getString("funcionario"));
                    vo.setDataExameRealizado(formatterDate.format(rs.getDate("data")));
                }
                return vo;
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(ExameRealizadoVo exameRealizado){

        StringBuilder query = new StringBuilder("UPDATE exame SET (nm_exame) = ? WHERE codigo_exame = ?");
        try(
                Connection con = getConexao();
                PreparedStatement  ps = con.prepareStatement(query.toString())
        ){
            int i=1;
            ps.setInt(i++, Integer.parseInt(exameRealizado.getCodigoExame()));
            ps.setInt(i++, Integer.parseInt(exameRealizado.getCodigoFuncionario()));
            ps.setDate(i++, Date.valueOf(exameRealizado.getDataExameRealizado()));
            ps.setInt(i++, Integer.parseInt(exameRealizado.getDataExameRealizado()));
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirExameRealizado(Integer codigo){
        StringBuilder query = new StringBuilder("DELETE FROM realizado WHERE codigo_exame_realizado = ?");
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
