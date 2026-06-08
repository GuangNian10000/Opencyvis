package ai.opencyvis.db;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
public final class GlobalMemoryDao_Impl implements GlobalMemoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GlobalMemoryEntity> __insertionAdapterOfGlobalMemoryEntity;

  private final EntityDeletionOrUpdateAdapter<GlobalMemoryEntity> __updateAdapterOfGlobalMemoryEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateByKey;

  private final SharedSQLiteStatement __preparedStmtOfDisable;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public GlobalMemoryDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGlobalMemoryEntity = new EntityInsertionAdapter<GlobalMemoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `global_memories` (`id`,`key`,`value`,`category`,`source`,`createdAt`,`updatedAt`,`enabled`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GlobalMemoryEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getKey());
        statement.bindString(3, entity.getValue());
        statement.bindString(4, entity.getCategory());
        statement.bindString(5, entity.getSource());
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
        final int _tmp = entity.getEnabled() ? 1 : 0;
        statement.bindLong(8, _tmp);
      }
    };
    this.__updateAdapterOfGlobalMemoryEntity = new EntityDeletionOrUpdateAdapter<GlobalMemoryEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `global_memories` SET `id` = ?,`key` = ?,`value` = ?,`category` = ?,`source` = ?,`createdAt` = ?,`updatedAt` = ?,`enabled` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final GlobalMemoryEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getKey());
        statement.bindString(3, entity.getValue());
        statement.bindString(4, entity.getCategory());
        statement.bindString(5, entity.getSource());
        statement.bindLong(6, entity.getCreatedAt());
        statement.bindLong(7, entity.getUpdatedAt());
        final int _tmp = entity.getEnabled() ? 1 : 0;
        statement.bindLong(8, _tmp);
        statement.bindLong(9, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateByKey = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE global_memories\n"
                + "        SET value = ?,\n"
                + "            category = ?,\n"
                + "            source = ?,\n"
                + "            updatedAt = ?,\n"
                + "            enabled = 1\n"
                + "        WHERE key = ?\n"
                + "        ";
        return _query;
      }
    };
    this.__preparedStmtOfDisable = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE global_memories SET enabled = 0, updatedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM global_memories WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final GlobalMemoryEntity memory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfGlobalMemoryEntity.insertAndReturnId(memory);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final GlobalMemoryEntity memory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGlobalMemoryEntity.handle(memory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public int updateByKey(final String key, final String value, final String category,
      final String source, final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateByKey.acquire();
    int _argIndex = 1;
    _stmt.bindString(_argIndex, value);
    _argIndex = 2;
    _stmt.bindString(_argIndex, category);
    _argIndex = 3;
    _stmt.bindString(_argIndex, source);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 5;
    _stmt.bindString(_argIndex, key);
    try {
      __db.beginTransaction();
      try {
        final int _result = _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateByKey.release(_stmt);
    }
  }

  @Override
  public int disable(final long id, final long updatedAt) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDisable.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, updatedAt);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        final int _result = _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDisable.release(_stmt);
    }
  }

  @Override
  public int delete(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        final int _result = _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
        return _result;
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<GlobalMemoryEntity> getAll() {
    final String _sql = "SELECT * FROM global_memories ORDER BY updatedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final int _cursorIndexOfEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "enabled");
      final List<GlobalMemoryEntity> _result = new ArrayList<GlobalMemoryEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final GlobalMemoryEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfKey);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnabled);
        _tmpEnabled = _tmp != 0;
        _item = new GlobalMemoryEntity(_tmpId,_tmpKey,_tmpValue,_tmpCategory,_tmpSource,_tmpCreatedAt,_tmpUpdatedAt,_tmpEnabled);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<GlobalMemoryEntity> getEnabled() {
    final String _sql = "\n"
            + "        SELECT * FROM global_memories\n"
            + "        WHERE enabled = 1\n"
            + "        ORDER BY updatedAt DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final int _cursorIndexOfEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "enabled");
      final List<GlobalMemoryEntity> _result = new ArrayList<GlobalMemoryEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final GlobalMemoryEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfKey);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnabled);
        _tmpEnabled = _tmp != 0;
        _item = new GlobalMemoryEntity(_tmpId,_tmpKey,_tmpValue,_tmpCategory,_tmpSource,_tmpCreatedAt,_tmpUpdatedAt,_tmpEnabled);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<GlobalMemoryEntity> search(final String query) {
    final String _sql = "\n"
            + "        SELECT * FROM global_memories\n"
            + "        WHERE key LIKE '%' || ? || '%'\n"
            + "           OR value LIKE '%' || ? || '%'\n"
            + "           OR category LIKE '%' || ? || '%'\n"
            + "        ORDER BY updatedAt DESC\n"
            + "        ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    _statement.bindString(_argIndex, query);
    _argIndex = 2;
    _statement.bindString(_argIndex, query);
    _argIndex = 3;
    _statement.bindString(_argIndex, query);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final int _cursorIndexOfEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "enabled");
      final List<GlobalMemoryEntity> _result = new ArrayList<GlobalMemoryEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final GlobalMemoryEntity _item;
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfKey);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnabled);
        _tmpEnabled = _tmp != 0;
        _item = new GlobalMemoryEntity(_tmpId,_tmpKey,_tmpValue,_tmpCategory,_tmpSource,_tmpCreatedAt,_tmpUpdatedAt,_tmpEnabled);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GlobalMemoryEntity getByKey(final String key) {
    final String _sql = "SELECT * FROM global_memories WHERE key = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, key);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "key");
      final int _cursorIndexOfValue = CursorUtil.getColumnIndexOrThrow(_cursor, "value");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
      final int _cursorIndexOfEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "enabled");
      final GlobalMemoryEntity _result;
      if (_cursor.moveToFirst()) {
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        final String _tmpKey;
        _tmpKey = _cursor.getString(_cursorIndexOfKey);
        final String _tmpValue;
        _tmpValue = _cursor.getString(_cursorIndexOfValue);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final String _tmpSource;
        _tmpSource = _cursor.getString(_cursorIndexOfSource);
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final long _tmpUpdatedAt;
        _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
        final boolean _tmpEnabled;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEnabled);
        _tmpEnabled = _tmp != 0;
        _result = new GlobalMemoryEntity(_tmpId,_tmpKey,_tmpValue,_tmpCategory,_tmpSource,_tmpCreatedAt,_tmpUpdatedAt,_tmpEnabled);
      } else {
        _result = null;
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
