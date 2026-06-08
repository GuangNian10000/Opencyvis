package ai.opencyvis.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ChatDao_Impl implements ChatDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ConversationEntity> __insertionAdapterOfConversationEntity;

  private final EntityInsertionAdapter<ChatMessageEntity> __insertionAdapterOfChatMessageEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteConversation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastAgentStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateLastMessageType;

  private final SharedSQLiteStatement __preparedStmtOfMarkStaleRunningAsStopped;

  public ChatDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfConversationEntity = new EntityInsertionAdapter<ConversationEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `conversations` (`id`,`title`,`status`,`createdAt`,`updatedAt`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ConversationEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getTitle());
        statement.bindString(3, entity.getStatus());
        statement.bindLong(4, entity.getCreatedAt());
        statement.bindLong(5, entity.getUpdatedAt());
      }
    };
    this.__insertionAdapterOfChatMessageEntity = new EntityInsertionAdapter<ChatMessageEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `chat_messages` (`id`,`conversationId`,`type`,`text`,`timestamp`,`source`,`remoteChatId`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ChatMessageEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getConversationId());
        statement.bindString(3, entity.getType());
        statement.bindString(4, entity.getText());
        statement.bindLong(5, entity.getTimestamp());
        statement.bindString(6, entity.getSource());
        if (entity.getRemoteChatId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getRemoteChatId());
        }
      }
    };
    this.__preparedStmtOfUpdateStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE conversations SET status = ?, updatedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteConversation = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM conversations WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastAgentStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE chat_messages SET text = ?, timestamp = ?\n"
                + "        WHERE id = (\n"
                + "            SELECT id FROM chat_messages\n"
                + "            WHERE conversationId = ? AND type = 'AGENT_STATUS'\n"
                + "            ORDER BY timestamp DESC LIMIT 1\n"
                + "        )\n"
                + "    ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateLastMessageType = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE chat_messages SET type = ?, timestamp = ?\n"
                + "        WHERE id = (\n"
                + "            SELECT id FROM chat_messages\n"
                + "            WHERE conversationId = ? AND type = ?\n"
                + "            ORDER BY timestamp DESC LIMIT 1\n"
                + "        )\n"
                + "    ";
        return _query;
      }
    };
    this.__preparedStmtOfMarkStaleRunningAsStopped = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE conversations SET status = 'stopped', updatedAt = ? WHERE status = 'running'";
        return _query;
      }
    };
  }

  @Override
  public long insertConversation(final ConversationEntity conv) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfConversationEntity.insertAndReturnId(conv);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertMessage(final ChatMessageEntity msg) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfChatMessageEntity.insert(msg);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateStatus(final long convId, final String status, final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatus.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, status);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, convId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateStatus.release(_stmt);
    }
  }

  @Override
  public void deleteConversation(final long convId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteConversation.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, convId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteConversation.release(_stmt);
    }
  }

  @Override
  public void updateLastAgentStatus(final long convId, final String text, final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastAgentStatus.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, text);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, convId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateLastAgentStatus.release(_stmt);
    }
  }

  @Override
  public void updateLastMessageType(final long convId, final String oldType, final String newType,
      final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateLastMessageType.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, newType);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 3;
    _stmt.bindLong(_argIndex, convId);
    _argIndex = 4;
    _stmt.bindString(_argIndex, oldType);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateLastMessageType.release(_stmt);
    }
  }

  @Override
  public void markStaleRunningAsStopped(final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfMarkStaleRunningAsStopped.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, updatedAt);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfMarkStaleRunningAsStopped.release(_stmt);
    }
  }

  @Override
  public List<ConversationEntity> getAllConversations() {
    final String _sql = "SELECT * FROM conversations ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<ConversationEntity> _result = new ArrayList<ConversationEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final ConversationEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpStatus;
        _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item = new ConversationEntity(_tmpId,_tmpTitle,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ConversationEntity> getRecentConversations(final int limit) {
    final String _sql = "SELECT * FROM conversations ORDER BY updatedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final List<ConversationEntity> _result = new ArrayList<ConversationEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final ConversationEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        final String _tmpStatus;
        _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        _item = new ConversationEntity(_tmpId,_tmpTitle,_tmpStatus,_tmpCreatedAt,_tmpUpdatedAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<ChatMessageEntity> getMessages(final long convId) {
    final String _sql = "SELECT * FROM chat_messages WHERE conversationId = ? ORDER BY timestamp ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, convId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfConversationId = CursorUtil.getColumnIndexOrThrow(_cursor, "conversationId");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfText = CursorUtil.getColumnIndexOrThrow(_cursor, "text");
      final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfRemoteChatId = CursorUtil.getColumnIndexOrThrow(_cursor, "remoteChatId");
      final List<ChatMessageEntity> _result = new ArrayList<ChatMessageEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final ChatMessageEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final long _tmpConversationId;
        _tmpConversationId = _cursor.getLong(_cursorIndexOfConversationId);
        final String _tmpType;
        _tmpType = _cursor.getString(_cursorIndexOfType);
        final String _tmpText;
        _tmpText = _cursor.getString(_cursorIndexOfText);
        final long _tmpTimestamp;
        _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final String _tmpRemoteChatId;
        if (_cursor.isNull(_cursorIndexOfRemoteChatId)) {
          _tmpRemoteChatId = null;
        } else {
          _tmpRemoteChatId = _cursor.getString(_cursorIndexOfRemoteChatId);
        }
        _item = new ChatMessageEntity(_tmpId,_tmpConversationId,_tmpType,_tmpText,_tmpTimestamp,_tmpSource,_tmpRemoteChatId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getStepCount(final long convId) {
    final String _sql = "SELECT COUNT(*) FROM chat_messages WHERE conversationId = ? AND type = 'AGENT_STATUS'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, convId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
