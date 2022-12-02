package com.exercise;

import com.exercise.board.BoardRowMapper;
import com.exercise.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BoardDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insertBoard() 기능 처리");
        String sql = "insert into BOARD1 (category, title, writer, content) values ("
                + "'" + vo.getCategory() + "',"
                + "'" + vo.getTitle() + "',"
                + "'" + vo.getWriter() + "',"
                + "'"+ vo.getContent() + "')";
        return jdbcTemplate.update(sql);
    }

    // 글 삭제
    public int deleteBoard(int seq) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        String sql = "delete from BOARD1 where seq= " + seq;
        return jdbcTemplate.update(sql);
    }
    public int updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        String sql = "update BOARD1 set category='" + vo.getCategory() + "',"
                + "title='" + vo.getTitle() + "',"
                + "writer='" + vo.getWriter() + "',"
                + "content='" + vo.getContent() + "' where seq=" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    public BoardVO getBoard(int seq){
        String sql = "select * from BOARD1 where seq=" + seq;
        return jdbcTemplate.queryForObject(sql,new BoardRowMapper());
    }

    public List<BoardVO> getBoardList(){
        String sql = "select * from BOARD1 order by seq desc";
        return jdbcTemplate.query(sql,new BoardRowMapper());
    }


}
