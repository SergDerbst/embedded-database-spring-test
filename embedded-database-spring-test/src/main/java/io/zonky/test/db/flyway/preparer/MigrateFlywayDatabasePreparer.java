package io.zonky.test.db.flyway.preparer;

import org.flywaydb.core.Flyway;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SettableListenableFuture;

public class MigrateFlywayDatabasePreparer extends FlywayDatabasePreparer {

    private final SettableListenableFuture<Integer> result = new SettableListenableFuture<>();

    public MigrateFlywayDatabasePreparer(Flyway flyway) {
        super(flyway);
    }

    public ListenableFuture<Integer> getResult() {
        return result;
    }

    @Override
    protected void doOperation(Flyway flyway) {
        try {
            result.set(flyway.migrate());
        } catch (RuntimeException e) {
            result.setException(e);
            throw e;
        }
    }
}