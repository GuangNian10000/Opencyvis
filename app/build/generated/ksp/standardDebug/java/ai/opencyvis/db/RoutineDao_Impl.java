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
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Double;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RoutineDao_Impl implements RoutineDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RoutineEntity> __insertionAdapterOfRoutineEntity;

  private final EntityInsertionAdapter<RoutineEntity> __insertionAdapterOfRoutineEntity_1;

  private final EntityDeletionOrUpdateAdapter<RoutineEntity> __deletionAdapterOfRoutineEntity;

  private final EntityDeletionOrUpdateAdapter<RoutineEntity> __updateAdapterOfRoutineEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteById;

  private final SharedSQLiteStatement __preparedStmtOfIncrementUseCount;

  private final SharedSQLiteStatement __preparedStmtOfSetPinned;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSortOrder;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTriggerTimes;

  private final SharedSQLiteStatement __preparedStmtOfSetScheduleEnabled;

  public RoutineDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoutineEntity = new EntityInsertionAdapter<RoutineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `routines` (`id`,`name`,`icon`,`instruction`,`description`,`category`,`isPinned`,`useCount`,`lastUsedAt`,`createdAt`,`sortOrder`,`scheduleEnabled`,`triggerType`,`scheduleHour`,`scheduleMinute`,`scheduleRepeatDays`,`intervalMinutes`,`intervalStartHour`,`intervalEndHour`,`geoLatitude`,`geoLongitude`,`geoRadiusMeters`,`geoTriggerOnEnter`,`geoLocationName`,`lastTriggeredAt`,`nextTriggerAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RoutineEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getIcon());
        statement.bindString(4, entity.getInstruction());
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        statement.bindString(6, entity.getCategory());
        final int _tmp = entity.isPinned() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getUseCount());
        if (entity.getLastUsedAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getLastUsedAt());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getSortOrder());
        final int _tmp_1 = entity.getScheduleEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_1);
        if (entity.getTriggerType() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTriggerType());
        }
        if (entity.getScheduleHour() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getScheduleHour());
        }
        if (entity.getScheduleMinute() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getScheduleMinute());
        }
        if (entity.getScheduleRepeatDays() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getScheduleRepeatDays());
        }
        if (entity.getIntervalMinutes() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getIntervalMinutes());
        }
        if (entity.getIntervalStartHour() == null) {
          statement.bindNull(18);
        } else {
          statement.bindLong(18, entity.getIntervalStartHour());
        }
        if (entity.getIntervalEndHour() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getIntervalEndHour());
        }
        if (entity.getGeoLatitude() == null) {
          statement.bindNull(20);
        } else {
          statement.bindDouble(20, entity.getGeoLatitude());
        }
        if (entity.getGeoLongitude() == null) {
          statement.bindNull(21);
        } else {
          statement.bindDouble(21, entity.getGeoLongitude());
        }
        if (entity.getGeoRadiusMeters() == null) {
          statement.bindNull(22);
        } else {
          statement.bindDouble(22, entity.getGeoRadiusMeters());
        }
        final Integer _tmp_2 = entity.getGeoTriggerOnEnter() == null ? null : (entity.getGeoTriggerOnEnter() ? 1 : 0);
        if (_tmp_2 == null) {
          statement.bindNull(23);
        } else {
          statement.bindLong(23, _tmp_2);
        }
        if (entity.getGeoLocationName() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getGeoLocationName());
        }
        if (entity.getLastTriggeredAt() == null) {
          statement.bindNull(25);
        } else {
          statement.bindLong(25, entity.getLastTriggeredAt());
        }
        if (entity.getNextTriggerAt() == null) {
          statement.bindNull(26);
        } else {
          statement.bindLong(26, entity.getNextTriggerAt());
        }
      }
    };
    this.__insertionAdapterOfRoutineEntity_1 = new EntityInsertionAdapter<RoutineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `routines` (`id`,`name`,`icon`,`instruction`,`description`,`category`,`isPinned`,`useCount`,`lastUsedAt`,`createdAt`,`sortOrder`,`scheduleEnabled`,`triggerType`,`scheduleHour`,`scheduleMinute`,`scheduleRepeatDays`,`intervalMinutes`,`intervalStartHour`,`intervalEndHour`,`geoLatitude`,`geoLongitude`,`geoRadiusMeters`,`geoTriggerOnEnter`,`geoLocationName`,`lastTriggeredAt`,`nextTriggerAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RoutineEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getIcon());
        statement.bindString(4, entity.getInstruction());
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        statement.bindString(6, entity.getCategory());
        final int _tmp = entity.isPinned() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getUseCount());
        if (entity.getLastUsedAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getLastUsedAt());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getSortOrder());
        final int _tmp_1 = entity.getScheduleEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_1);
        if (entity.getTriggerType() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTriggerType());
        }
        if (entity.getScheduleHour() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getScheduleHour());
        }
        if (entity.getScheduleMinute() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getScheduleMinute());
        }
        if (entity.getScheduleRepeatDays() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getScheduleRepeatDays());
        }
        if (entity.getIntervalMinutes() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getIntervalMinutes());
        }
        if (entity.getIntervalStartHour() == null) {
          statement.bindNull(18);
        } else {
          statement.bindLong(18, entity.getIntervalStartHour());
        }
        if (entity.getIntervalEndHour() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getIntervalEndHour());
        }
        if (entity.getGeoLatitude() == null) {
          statement.bindNull(20);
        } else {
          statement.bindDouble(20, entity.getGeoLatitude());
        }
        if (entity.getGeoLongitude() == null) {
          statement.bindNull(21);
        } else {
          statement.bindDouble(21, entity.getGeoLongitude());
        }
        if (entity.getGeoRadiusMeters() == null) {
          statement.bindNull(22);
        } else {
          statement.bindDouble(22, entity.getGeoRadiusMeters());
        }
        final Integer _tmp_2 = entity.getGeoTriggerOnEnter() == null ? null : (entity.getGeoTriggerOnEnter() ? 1 : 0);
        if (_tmp_2 == null) {
          statement.bindNull(23);
        } else {
          statement.bindLong(23, _tmp_2);
        }
        if (entity.getGeoLocationName() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getGeoLocationName());
        }
        if (entity.getLastTriggeredAt() == null) {
          statement.bindNull(25);
        } else {
          statement.bindLong(25, entity.getLastTriggeredAt());
        }
        if (entity.getNextTriggerAt() == null) {
          statement.bindNull(26);
        } else {
          statement.bindLong(26, entity.getNextTriggerAt());
        }
      }
    };
    this.__deletionAdapterOfRoutineEntity = new EntityDeletionOrUpdateAdapter<RoutineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `routines` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RoutineEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfRoutineEntity = new EntityDeletionOrUpdateAdapter<RoutineEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `routines` SET `id` = ?,`name` = ?,`icon` = ?,`instruction` = ?,`description` = ?,`category` = ?,`isPinned` = ?,`useCount` = ?,`lastUsedAt` = ?,`createdAt` = ?,`sortOrder` = ?,`scheduleEnabled` = ?,`triggerType` = ?,`scheduleHour` = ?,`scheduleMinute` = ?,`scheduleRepeatDays` = ?,`intervalMinutes` = ?,`intervalStartHour` = ?,`intervalEndHour` = ?,`geoLatitude` = ?,`geoLongitude` = ?,`geoRadiusMeters` = ?,`geoTriggerOnEnter` = ?,`geoLocationName` = ?,`lastTriggeredAt` = ?,`nextTriggerAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final RoutineEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getIcon());
        statement.bindString(4, entity.getInstruction());
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        statement.bindString(6, entity.getCategory());
        final int _tmp = entity.isPinned() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getUseCount());
        if (entity.getLastUsedAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getLastUsedAt());
        }
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getSortOrder());
        final int _tmp_1 = entity.getScheduleEnabled() ? 1 : 0;
        statement.bindLong(12, _tmp_1);
        if (entity.getTriggerType() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getTriggerType());
        }
        if (entity.getScheduleHour() == null) {
          statement.bindNull(14);
        } else {
          statement.bindLong(14, entity.getScheduleHour());
        }
        if (entity.getScheduleMinute() == null) {
          statement.bindNull(15);
        } else {
          statement.bindLong(15, entity.getScheduleMinute());
        }
        if (entity.getScheduleRepeatDays() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getScheduleRepeatDays());
        }
        if (entity.getIntervalMinutes() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getIntervalMinutes());
        }
        if (entity.getIntervalStartHour() == null) {
          statement.bindNull(18);
        } else {
          statement.bindLong(18, entity.getIntervalStartHour());
        }
        if (entity.getIntervalEndHour() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getIntervalEndHour());
        }
        if (entity.getGeoLatitude() == null) {
          statement.bindNull(20);
        } else {
          statement.bindDouble(20, entity.getGeoLatitude());
        }
        if (entity.getGeoLongitude() == null) {
          statement.bindNull(21);
        } else {
          statement.bindDouble(21, entity.getGeoLongitude());
        }
        if (entity.getGeoRadiusMeters() == null) {
          statement.bindNull(22);
        } else {
          statement.bindDouble(22, entity.getGeoRadiusMeters());
        }
        final Integer _tmp_2 = entity.getGeoTriggerOnEnter() == null ? null : (entity.getGeoTriggerOnEnter() ? 1 : 0);
        if (_tmp_2 == null) {
          statement.bindNull(23);
        } else {
          statement.bindLong(23, _tmp_2);
        }
        if (entity.getGeoLocationName() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getGeoLocationName());
        }
        if (entity.getLastTriggeredAt() == null) {
          statement.bindNull(25);
        } else {
          statement.bindLong(25, entity.getLastTriggeredAt());
        }
        if (entity.getNextTriggerAt() == null) {
          statement.bindNull(26);
        } else {
          statement.bindLong(26, entity.getNextTriggerAt());
        }
        statement.bindLong(27, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM routines WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfIncrementUseCount = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE routines SET useCount = useCount + 1, lastUsedAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetPinned = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE routines SET isPinned = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSortOrder = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE routines SET sortOrder = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateTriggerTimes = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE routines SET lastTriggeredAt = ?, nextTriggerAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfSetScheduleEnabled = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE routines SET scheduleEnabled = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public long insertRoutine(final RoutineEntity routine) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfRoutineEntity.insertAndReturnId(routine);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertRoutines(final List<RoutineEntity> routines) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoutineEntity_1.insert(routines);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRoutine(final RoutineEntity routine) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoutineEntity.handle(routine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRoutine(final RoutineEntity routine) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRoutineEntity.handle(routine);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteById(final int routineId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, routineId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteById.release(_stmt);
    }
  }

  @Override
  public void incrementUseCount(final int routineId, final long now) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfIncrementUseCount.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, now);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, routineId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfIncrementUseCount.release(_stmt);
    }
  }

  @Override
  public void setPinned(final int routineId, final boolean pinned) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetPinned.acquire();
    int _argIndex = 1;
    final int _tmp = pinned ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, routineId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfSetPinned.release(_stmt);
    }
  }

  @Override
  public void updateSortOrder(final int routineId, final int order) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSortOrder.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, order);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, routineId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateSortOrder.release(_stmt);
    }
  }

  @Override
  public void updateTriggerTimes(final int id, final long now, final Long next) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTriggerTimes.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, now);
    _argIndex = 2;
    if (next == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindLong(_argIndex, next);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdateTriggerTimes.release(_stmt);
    }
  }

  @Override
  public void setScheduleEnabled(final int id, final boolean enabled) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetScheduleEnabled.acquire();
    int _argIndex = 1;
    final int _tmp = enabled ? 1 : 0;
    _stmt.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfSetScheduleEnabled.release(_stmt);
    }
  }

  @Override
  public List<RoutineEntity> getAllRoutines() {
    final String _sql = "SELECT * FROM routines ORDER BY sortOrder ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoutineEntity getPinnedRoutine() {
    final String _sql = "SELECT * FROM routines WHERE isPinned = 1 ORDER BY useCount DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final RoutineEntity _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _result = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoutineEntity getTopUsedRoutine() {
    final String _sql = "SELECT * FROM routines WHERE isPinned = 0 ORDER BY useCount DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final RoutineEntity _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _result = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoutineEntity getMostUsedRoutine() {
    final String _sql = "SELECT * FROM routines ORDER BY useCount DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final RoutineEntity _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _result = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoutineEntity> getRecentRoutines(final int limit) {
    final String _sql = "SELECT * FROM routines WHERE lastUsedAt IS NOT NULL ORDER BY lastUsedAt DESC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, limit);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoutineEntity> getBuiltinRoutines() {
    final String _sql = "SELECT * FROM routines WHERE category = 'builtin' ORDER BY sortOrder ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoutineEntity> getCustomRoutines() {
    final String _sql = "SELECT * FROM routines WHERE category = 'custom' ORDER BY lastUsedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoutineEntity> getDebugRoutines() {
    final String _sql = "SELECT * FROM routines WHERE category = 'debug' ORDER BY sortOrder ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getCount() {
    final String _sql = "SELECT COUNT(*) FROM routines";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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

  @Override
  public List<RoutineEntity> getScheduledRoutines() {
    final String _sql = "SELECT * FROM routines WHERE scheduleEnabled = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<RoutineEntity> getGeofenceRoutines() {
    final String _sql = "SELECT * FROM routines WHERE scheduleEnabled = 1 AND triggerType = 'geofence'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final List<RoutineEntity> _result = new ArrayList<RoutineEntity>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final RoutineEntity _item;
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _item = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public RoutineEntity getById(final int id) {
    final String _sql = "SELECT * FROM routines WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfIcon = CursorUtil.getColumnIndexOrThrow(_cursor, "icon");
      final int _cursorIndexOfInstruction = CursorUtil.getColumnIndexOrThrow(_cursor, "instruction");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfIsPinned = CursorUtil.getColumnIndexOrThrow(_cursor, "isPinned");
      final int _cursorIndexOfUseCount = CursorUtil.getColumnIndexOrThrow(_cursor, "useCount");
      final int _cursorIndexOfLastUsedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUsedAt");
      final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
      final int _cursorIndexOfSortOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "sortOrder");
      final int _cursorIndexOfScheduleEnabled = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleEnabled");
      final int _cursorIndexOfTriggerType = CursorUtil.getColumnIndexOrThrow(_cursor, "triggerType");
      final int _cursorIndexOfScheduleHour = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleHour");
      final int _cursorIndexOfScheduleMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleMinute");
      final int _cursorIndexOfScheduleRepeatDays = CursorUtil.getColumnIndexOrThrow(_cursor, "scheduleRepeatDays");
      final int _cursorIndexOfIntervalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalMinutes");
      final int _cursorIndexOfIntervalStartHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalStartHour");
      final int _cursorIndexOfIntervalEndHour = CursorUtil.getColumnIndexOrThrow(_cursor, "intervalEndHour");
      final int _cursorIndexOfGeoLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLatitude");
      final int _cursorIndexOfGeoLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLongitude");
      final int _cursorIndexOfGeoRadiusMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "geoRadiusMeters");
      final int _cursorIndexOfGeoTriggerOnEnter = CursorUtil.getColumnIndexOrThrow(_cursor, "geoTriggerOnEnter");
      final int _cursorIndexOfGeoLocationName = CursorUtil.getColumnIndexOrThrow(_cursor, "geoLocationName");
      final int _cursorIndexOfLastTriggeredAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastTriggeredAt");
      final int _cursorIndexOfNextTriggerAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextTriggerAt");
      final RoutineEntity _result;
      if (_cursor.moveToFirst()) {
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpIcon;
        _tmpIcon = _cursor.getString(_cursorIndexOfIcon);
        final String _tmpInstruction;
        _tmpInstruction = _cursor.getString(_cursorIndexOfInstruction);
        final String _tmpDescription;
        if (_cursor.isNull(_cursorIndexOfDescription)) {
          _tmpDescription = null;
        } else {
          _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        }
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final boolean _tmpIsPinned;
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfIsPinned);
        _tmpIsPinned = _tmp != 0;
        final int _tmpUseCount;
        _tmpUseCount = _cursor.getInt(_cursorIndexOfUseCount);
        final Long _tmpLastUsedAt;
        if (_cursor.isNull(_cursorIndexOfLastUsedAt)) {
          _tmpLastUsedAt = null;
        } else {
          _tmpLastUsedAt = _cursor.getLong(_cursorIndexOfLastUsedAt);
        }
        final long _tmpCreatedAt;
        _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
        final int _tmpSortOrder;
        _tmpSortOrder = _cursor.getInt(_cursorIndexOfSortOrder);
        final boolean _tmpScheduleEnabled;
        final int _tmp_1;
        _tmp_1 = _cursor.getInt(_cursorIndexOfScheduleEnabled);
        _tmpScheduleEnabled = _tmp_1 != 0;
        final String _tmpTriggerType;
        if (_cursor.isNull(_cursorIndexOfTriggerType)) {
          _tmpTriggerType = null;
        } else {
          _tmpTriggerType = _cursor.getString(_cursorIndexOfTriggerType);
        }
        final Integer _tmpScheduleHour;
        if (_cursor.isNull(_cursorIndexOfScheduleHour)) {
          _tmpScheduleHour = null;
        } else {
          _tmpScheduleHour = _cursor.getInt(_cursorIndexOfScheduleHour);
        }
        final Integer _tmpScheduleMinute;
        if (_cursor.isNull(_cursorIndexOfScheduleMinute)) {
          _tmpScheduleMinute = null;
        } else {
          _tmpScheduleMinute = _cursor.getInt(_cursorIndexOfScheduleMinute);
        }
        final String _tmpScheduleRepeatDays;
        if (_cursor.isNull(_cursorIndexOfScheduleRepeatDays)) {
          _tmpScheduleRepeatDays = null;
        } else {
          _tmpScheduleRepeatDays = _cursor.getString(_cursorIndexOfScheduleRepeatDays);
        }
        final Integer _tmpIntervalMinutes;
        if (_cursor.isNull(_cursorIndexOfIntervalMinutes)) {
          _tmpIntervalMinutes = null;
        } else {
          _tmpIntervalMinutes = _cursor.getInt(_cursorIndexOfIntervalMinutes);
        }
        final Integer _tmpIntervalStartHour;
        if (_cursor.isNull(_cursorIndexOfIntervalStartHour)) {
          _tmpIntervalStartHour = null;
        } else {
          _tmpIntervalStartHour = _cursor.getInt(_cursorIndexOfIntervalStartHour);
        }
        final Integer _tmpIntervalEndHour;
        if (_cursor.isNull(_cursorIndexOfIntervalEndHour)) {
          _tmpIntervalEndHour = null;
        } else {
          _tmpIntervalEndHour = _cursor.getInt(_cursorIndexOfIntervalEndHour);
        }
        final Double _tmpGeoLatitude;
        if (_cursor.isNull(_cursorIndexOfGeoLatitude)) {
          _tmpGeoLatitude = null;
        } else {
          _tmpGeoLatitude = _cursor.getDouble(_cursorIndexOfGeoLatitude);
        }
        final Double _tmpGeoLongitude;
        if (_cursor.isNull(_cursorIndexOfGeoLongitude)) {
          _tmpGeoLongitude = null;
        } else {
          _tmpGeoLongitude = _cursor.getDouble(_cursorIndexOfGeoLongitude);
        }
        final Float _tmpGeoRadiusMeters;
        if (_cursor.isNull(_cursorIndexOfGeoRadiusMeters)) {
          _tmpGeoRadiusMeters = null;
        } else {
          _tmpGeoRadiusMeters = _cursor.getFloat(_cursorIndexOfGeoRadiusMeters);
        }
        final Boolean _tmpGeoTriggerOnEnter;
        final Integer _tmp_2;
        if (_cursor.isNull(_cursorIndexOfGeoTriggerOnEnter)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getInt(_cursorIndexOfGeoTriggerOnEnter);
        }
        _tmpGeoTriggerOnEnter = _tmp_2 == null ? null : _tmp_2 != 0;
        final String _tmpGeoLocationName;
        if (_cursor.isNull(_cursorIndexOfGeoLocationName)) {
          _tmpGeoLocationName = null;
        } else {
          _tmpGeoLocationName = _cursor.getString(_cursorIndexOfGeoLocationName);
        }
        final Long _tmpLastTriggeredAt;
        if (_cursor.isNull(_cursorIndexOfLastTriggeredAt)) {
          _tmpLastTriggeredAt = null;
        } else {
          _tmpLastTriggeredAt = _cursor.getLong(_cursorIndexOfLastTriggeredAt);
        }
        final Long _tmpNextTriggerAt;
        if (_cursor.isNull(_cursorIndexOfNextTriggerAt)) {
          _tmpNextTriggerAt = null;
        } else {
          _tmpNextTriggerAt = _cursor.getLong(_cursorIndexOfNextTriggerAt);
        }
        _result = new RoutineEntity(_tmpId,_tmpName,_tmpIcon,_tmpInstruction,_tmpDescription,_tmpCategory,_tmpIsPinned,_tmpUseCount,_tmpLastUsedAt,_tmpCreatedAt,_tmpSortOrder,_tmpScheduleEnabled,_tmpTriggerType,_tmpScheduleHour,_tmpScheduleMinute,_tmpScheduleRepeatDays,_tmpIntervalMinutes,_tmpIntervalStartHour,_tmpIntervalEndHour,_tmpGeoLatitude,_tmpGeoLongitude,_tmpGeoRadiusMeters,_tmpGeoTriggerOnEnter,_tmpGeoLocationName,_tmpLastTriggeredAt,_tmpNextTriggerAt);
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
