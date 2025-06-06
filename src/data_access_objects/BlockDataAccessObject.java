package data_access_objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import models.Block;

public class BlockDataAccessObject {
	
	private Connection connection;
	
	protected BlockDataAccessObject(Connection connection) {
		this.connection = connection;
	}
	
	public Block addNote(Block block) throws SQLException {
		String query = "INSERT INTO blocks (type, page_id, order_index, previous_block_id, next_block_id) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, block.getType());
			statement.setLong(2, block.getParentPageId());
			statement.setLong(3, block.getOrderIndex());
			if (block.getPreviousId() == null) {
				statement.setLong(4, block.getPreviousId());
			} else {
				statement.setNull(4, Types.BIGINT);
			}
			if (block.getNextId() != null) {
				statement.setLong(5, block.getNextId());
			} else {
				statement.setNull(5, Types.BIGINT);
			}
			statement.executeUpdate();
			
			try (ResultSet generatedKeys = statement.getGeneratedKeys()){
				if (generatedKeys.next()) {
					long id = generatedKeys.getLong(1);
					block.setblockId(id);
					return block; // Return the block with the generated ID
				} else {
					throw new SQLException("Creating block failed, no ID obtained.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Re-throw the exception for further handling
		}
	}
	
	public boolean deleteBlock(Block block) throws SQLException {
		String query = "DELETE FROM blocks WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setLong(1, block.getblockId());
			int rowsAffected = statement.executeUpdate();
			return rowsAffected > 0; // Return true if a block was deleted
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Re-throw the exception for further handling
		}
	}
	
	public Block updateBlock(Block block) throws SQLException {
		String query = "UPDATE blocks SET type = ?, page_id = ?, order_index = ?, previous_block_id = ?, next_block_id = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, block.getType());
			statement.setLong(2, block.getParentPageId());
			statement.setLong(3, block.getOrderIndex());
			if (block.getPreviousId() == null) {
				statement.setNull(4, Types.BIGINT);
			} else {
				statement.setLong(4, block.getPreviousId());
			}
			if (block.getNextId() == null) {
				statement.setNull(5, Types.BIGINT);
			} else {
				statement.setLong(5, block.getNextId());
			}
			statement.setLong(6, block.getblockId());
			statement.executeUpdate();
			return block; // Return the updated block
		} catch (SQLException e) {
			e.printStackTrace();
			throw e; // Re-throw the exception for further handling
		}
	}
}
