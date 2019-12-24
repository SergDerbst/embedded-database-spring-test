package io.zonky.test.db.flyway;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationVersion;
import org.flywaydb.core.api.resolver.MigrationResolver;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FlywayDescriptor {

    // not included in equals and hashCode methods
    private final OutputStream dryRunOutput;

    // included in equals and hashCode methods
    // but it will work only for empty arrays (that is common use-case)
    // because of missing equals and hashCode methods
    // on classes implementing these interfaces
    private final List<MigrationResolver> resolvers;
    private final List<Object> callbacks; // TODO: check if the callbacks are still modified during the migration or not...
    private final List<Object> errorHandlers;

    // included in equals and hashCode methods
    private final MigrationVersion baselineVersion;
    private final MigrationVersion targetVersion;
    private final List<String> locations;
    private final List<String> schemas;
    private final List<String> sqlMigrationSuffixes;
    private final List<String> errorOverrides;
    private final Map<String, String> placeholders;
    private final String table;
    private final String baselineDescription;
    private final String undoSqlMigrationPrefix;
    private final String repeatableSqlMigrationPrefix;
    private final String sqlMigrationSeparator;
    private final String sqlMigrationPrefix;
    private final String placeholderPrefix;
    private final String placeholderSuffix;
    private final String encoding;
    private final String initSql;
    private final String licenseKey;
    private final boolean skipDefaultResolvers;
    private final boolean skipDefaultCallbacks;
    private final boolean placeholderReplacement;
    private final boolean baselineOnMigrate;
    private final boolean outOfOrder;
    private final boolean ignoreMissingMigrations;
    private final boolean ignoreIgnoredMigrations;
    private final boolean ignorePendingMigrations;
    private final boolean ignoreFutureMigrations;
    private final boolean validateOnMigrate;
    private final boolean cleanOnValidationError;
    private final boolean cleanDisabled;
    private final boolean allowMixedMigrations;
    private final boolean mixed;
    private final boolean group;
    private final String installedBy;
    private final boolean dryRun;
    private final boolean stream;
    private final boolean batch;
    private final boolean oracleSqlPlus;
    private final int connectRetries;

    public MigrationVersion getBaselineVersion() {
        return baselineVersion;
    }

    public MigrationVersion getTargetVersion() {
        return targetVersion;
    }

    public List<String> getLocations() {
        return locations;
    }

    public List<String> getSchemas() {
        return schemas;
    }

    public List<String> getSqlMigrationSuffixes() {
        return sqlMigrationSuffixes;
    }

    public List<String> getErrorOverrides() {
        return errorOverrides;
    }

    public Map<String, String> getPlaceholders() {
        return placeholders;
    }

    public String getTable() {
        return table;
    }

    public String getBaselineDescription() {
        return baselineDescription;
    }

    public String getUndoSqlMigrationPrefix() {
        return undoSqlMigrationPrefix;
    }

    public String getRepeatableSqlMigrationPrefix() {
        return repeatableSqlMigrationPrefix;
    }

    public String getSqlMigrationSeparator() {
        return sqlMigrationSeparator;
    }

    public String getSqlMigrationPrefix() {
        return sqlMigrationPrefix;
    }

    public String getPlaceholderPrefix() {
        return placeholderPrefix;
    }

    public String getPlaceholderSuffix() {
        return placeholderSuffix;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getInitSql() {
        return initSql;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public boolean isSkipDefaultResolvers() {
        return skipDefaultResolvers;
    }

    public boolean isSkipDefaultCallbacks() {
        return skipDefaultCallbacks;
    }

    public boolean isPlaceholderReplacement() {
        return placeholderReplacement;
    }

    public boolean isBaselineOnMigrate() {
        return baselineOnMigrate;
    }

    public boolean isOutOfOrder() {
        return outOfOrder;
    }

    public boolean isIgnoreMissingMigrations() {
        return ignoreMissingMigrations;
    }

    public boolean isIgnoreIgnoredMigrations() {
        return ignoreIgnoredMigrations;
    }

    public boolean isIgnorePendingMigrations() {
        return ignorePendingMigrations;
    }

    public boolean isIgnoreFutureMigrations() {
        return ignoreFutureMigrations;
    }

    public boolean isValidateOnMigrate() {
        return validateOnMigrate;
    }

    public boolean isCleanOnValidationError() {
        return cleanOnValidationError;
    }

    public boolean isCleanDisabled() {
        return cleanDisabled;
    }

    public boolean isAllowMixedMigrations() {
        return allowMixedMigrations;
    }

    public boolean isMixed() {
        return mixed;
    }

    public boolean isGroup() {
        return group;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public boolean isDryRun() {
        return dryRun;
    }

    public boolean isStream() {
        return stream;
    }

    public boolean isBatch() {
        return batch;
    }

    public boolean isOracleSqlPlus() {
        return oracleSqlPlus;
    }

    public int getConnectRetries() {
        return connectRetries;
    }

    private FlywayDescriptor(List<Object> callbacks, List<MigrationResolver> resolvers, List<Object> errorHandlers, MigrationVersion baselineVersion, MigrationVersion targetVersion, List<String> locations, List<String> schemas, List<String> sqlMigrationSuffixes, List<String> errorOverrides, Map<String, String> placeholders, String table, String baselineDescription, String undoSqlMigrationPrefix, String repeatableSqlMigrationPrefix, String sqlMigrationSeparator, String sqlMigrationPrefix, String placeholderPrefix, String placeholderSuffix, String encoding, String initSql, String licenseKey, boolean skipDefaultResolvers, boolean skipDefaultCallbacks, boolean placeholderReplacement, boolean baselineOnMigrate, boolean outOfOrder, boolean ignoreMissingMigrations, boolean ignoreIgnoredMigrations, boolean ignorePendingMigrations, boolean ignoreFutureMigrations, boolean validateOnMigrate, boolean cleanOnValidationError, boolean cleanDisabled, boolean allowMixedMigrations, boolean mixed, boolean group, String installedBy, OutputStream dryRunOutput, boolean stream, boolean batch, boolean oracleSqlPlus, int connectRetries) {
        this.callbacks = ImmutableList.copyOf(callbacks);
        this.resolvers = ImmutableList.copyOf(resolvers);
        this.errorHandlers = ImmutableList.copyOf(errorHandlers);
        this.baselineVersion = baselineVersion;
        this.targetVersion = targetVersion;
        this.locations = ImmutableList.copyOf(locations);
        this.schemas = ImmutableList.copyOf(schemas);
        this.sqlMigrationSuffixes = ImmutableList.copyOf(sqlMigrationSuffixes);
        this.errorOverrides = ImmutableList.copyOf(errorOverrides);
        this.placeholders = ImmutableMap.copyOf(placeholders);
        this.table = table;
        this.baselineDescription = baselineDescription;
        this.undoSqlMigrationPrefix = undoSqlMigrationPrefix;
        this.repeatableSqlMigrationPrefix = repeatableSqlMigrationPrefix;
        this.sqlMigrationSeparator = sqlMigrationSeparator;
        this.sqlMigrationPrefix = sqlMigrationPrefix;
        this.placeholderPrefix = placeholderPrefix;
        this.placeholderSuffix = placeholderSuffix;
        this.encoding = encoding;
        this.initSql = initSql;
        this.licenseKey = licenseKey;
        this.skipDefaultResolvers = skipDefaultResolvers;
        this.skipDefaultCallbacks = skipDefaultCallbacks;
        this.placeholderReplacement = placeholderReplacement;
        this.baselineOnMigrate = baselineOnMigrate;
        this.outOfOrder = outOfOrder;
        this.ignoreMissingMigrations = ignoreMissingMigrations;
        this.ignoreIgnoredMigrations = ignoreIgnoredMigrations;
        this.ignorePendingMigrations = ignorePendingMigrations;
        this.ignoreFutureMigrations = ignoreFutureMigrations;
        this.validateOnMigrate = validateOnMigrate;
        this.cleanOnValidationError = cleanOnValidationError;
        this.cleanDisabled = cleanDisabled;
        this.allowMixedMigrations = allowMixedMigrations;
        this.mixed = mixed;
        this.group = group;
        this.installedBy = installedBy;
        this.dryRunOutput = dryRunOutput;
        this.dryRun = dryRunOutput != null;
        this.stream = stream;
        this.batch = batch;
        this.oracleSqlPlus = oracleSqlPlus;
        this.connectRetries = connectRetries;
    }

    public static FlywayDescriptor from(Flyway flyway) {
        FlywayWrapper wrapper = new FlywayWrapper(flyway);
        return new FlywayDescriptor(
                wrapper.getCallbacks(),
                wrapper.getResolvers(),
                wrapper.getErrorHandlers(),
                wrapper.getBaselineVersion(),
                wrapper.getTargetVersion(),
                wrapper.getLocations(),
                wrapper.getSchemas(),
                wrapper.getSqlMigrationSuffixes(),
                wrapper.getErrorOverrides(),
                wrapper.getPlaceholders(),
                wrapper.getTable(),
                wrapper.getBaselineDescription(),
                wrapper.getUndoSqlMigrationPrefix(),
                wrapper.getRepeatableSqlMigrationPrefix(),
                wrapper.getSqlMigrationSeparator(),
                wrapper.getSqlMigrationPrefix(),
                wrapper.getPlaceholderPrefix(),
                wrapper.getPlaceholderSuffix(),
                wrapper.getEncoding(),
                wrapper.getInitSql(),
                wrapper.getLicenseKey(),
                wrapper.isSkipDefaultResolvers(),
                wrapper.isSkipDefaultCallbacks(),
                wrapper.isPlaceholderReplacement(),
                wrapper.isBaselineOnMigrate(),
                wrapper.isOutOfOrder(),
                wrapper.isIgnoreMissingMigrations(),
                wrapper.isIgnoreIgnoredMigrations(),
                wrapper.isIgnorePendingMigrations(),
                wrapper.isIgnoreFutureMigrations(),
                wrapper.isValidateOnMigrate(),
                wrapper.isCleanOnValidationError(),
                wrapper.isCleanDisabled(),
                wrapper.isAllowMixedMigrations(),
                wrapper.isMixed(),
                wrapper.isGroup(),
                wrapper.getInstalledBy(),
                wrapper.getDryRunOutput(),
                wrapper.isStream(),
                wrapper.isBatch(),
                wrapper.isOracleSqlPlus(),
                wrapper.getConnectRetries()
        );
    }

    public void applyTo(Flyway flyway) {
        FlywayWrapper wrapper = new FlywayWrapper(flyway);
        wrapper.setCallbacks(callbacks);
        wrapper.setResolvers(resolvers);
        wrapper.setErrorHandlers(errorHandlers);
        wrapper.setBaselineVersion(baselineVersion);
        wrapper.setTarget(targetVersion);
        wrapper.setLocations(locations);
        wrapper.setSchemas(schemas);
        wrapper.setSqlMigrationSuffixes(sqlMigrationSuffixes);
        wrapper.setErrorOverrides(errorOverrides);
        wrapper.setPlaceholders(placeholders);
        wrapper.setTable(table);
        wrapper.setBaselineDescription(baselineDescription);
        wrapper.setUndoSqlMigrationPrefix(undoSqlMigrationPrefix);
        wrapper.setRepeatableSqlMigrationPrefix(repeatableSqlMigrationPrefix);
        wrapper.setSqlMigrationSeparator(sqlMigrationSeparator);
        wrapper.setSqlMigrationPrefix(sqlMigrationPrefix);
        wrapper.setPlaceholderPrefix(placeholderPrefix);
        wrapper.setPlaceholderSuffix(placeholderSuffix);
        wrapper.setEncoding(encoding);
        wrapper.setInitSql(initSql);
        wrapper.setLicenseKey(licenseKey);
        wrapper.setSkipDefaultResolvers(skipDefaultResolvers);
        wrapper.setSkipDefaultCallbacks(skipDefaultCallbacks);
        wrapper.setPlaceholderReplacement(placeholderReplacement);
        wrapper.setBaselineOnMigrate(baselineOnMigrate);
        wrapper.setOutOfOrder(outOfOrder);
        wrapper.setIgnoreMissingMigrations(ignoreMissingMigrations);
        wrapper.setIgnoreIgnoredMigrations(ignoreIgnoredMigrations);
        wrapper.setIgnorePendingMigrations(ignorePendingMigrations);
        wrapper.setIgnoreFutureMigrations(ignoreFutureMigrations);
        wrapper.setValidateOnMigrate(validateOnMigrate);
        wrapper.setCleanOnValidationError(cleanOnValidationError);
        wrapper.setCleanDisabled(cleanDisabled);
        wrapper.setAllowMixedMigrations(allowMixedMigrations);
        wrapper.setMixed(mixed);
        wrapper.setGroup(group);
        wrapper.setInstalledBy(installedBy);
        wrapper.setDryRunOutput(dryRunOutput);
        wrapper.setStream(stream);
        wrapper.setBatch(batch);
        wrapper.setOracleSqlPlus(oracleSqlPlus);
        wrapper.setConnectRetries(connectRetries);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlywayDescriptor that = (FlywayDescriptor) o;
        return skipDefaultResolvers == that.skipDefaultResolvers &&
                skipDefaultCallbacks == that.skipDefaultCallbacks &&
                placeholderReplacement == that.placeholderReplacement &&
                baselineOnMigrate == that.baselineOnMigrate &&
                outOfOrder == that.outOfOrder &&
                ignoreMissingMigrations == that.ignoreMissingMigrations &&
                ignoreIgnoredMigrations == that.ignoreIgnoredMigrations &&
                ignorePendingMigrations == that.ignorePendingMigrations &&
                ignoreFutureMigrations == that.ignoreFutureMigrations &&
                validateOnMigrate == that.validateOnMigrate &&
                cleanOnValidationError == that.cleanOnValidationError &&
                cleanDisabled == that.cleanDisabled &&
                allowMixedMigrations == that.allowMixedMigrations &&
                mixed == that.mixed &&
                group == that.group &&
                dryRun == that.dryRun &&
                stream == that.stream &&
                batch == that.batch &&
                oracleSqlPlus == that.oracleSqlPlus &&
                connectRetries == that.connectRetries &&
                Objects.equals(resolvers, that.resolvers) &&
                Objects.equals(errorHandlers, that.errorHandlers) &&
                Objects.equals(baselineVersion, that.baselineVersion) &&
                Objects.equals(targetVersion, that.targetVersion) &&
                Objects.equals(locations, that.locations) &&
                Objects.equals(schemas, that.schemas) &&
                Objects.equals(sqlMigrationSuffixes, that.sqlMigrationSuffixes) &&
                Objects.equals(errorOverrides, that.errorOverrides) &&
                Objects.equals(placeholders, that.placeholders) &&
                Objects.equals(table, that.table) &&
                Objects.equals(baselineDescription, that.baselineDescription) &&
                Objects.equals(undoSqlMigrationPrefix, that.undoSqlMigrationPrefix) &&
                Objects.equals(repeatableSqlMigrationPrefix, that.repeatableSqlMigrationPrefix) &&
                Objects.equals(sqlMigrationSeparator, that.sqlMigrationSeparator) &&
                Objects.equals(sqlMigrationPrefix, that.sqlMigrationPrefix) &&
                Objects.equals(placeholderPrefix, that.placeholderPrefix) &&
                Objects.equals(placeholderSuffix, that.placeholderSuffix) &&
                Objects.equals(encoding, that.encoding) &&
                Objects.equals(initSql, that.initSql) &&
                Objects.equals(licenseKey, that.licenseKey) &&
                Objects.equals(installedBy, that.installedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                resolvers, errorHandlers,
                baselineVersion, targetVersion, locations, schemas, sqlMigrationSuffixes,
                errorOverrides, placeholders, table, baselineDescription,
                undoSqlMigrationPrefix, repeatableSqlMigrationPrefix,
                sqlMigrationSeparator, sqlMigrationPrefix, placeholderPrefix,
                placeholderSuffix, encoding, initSql, licenseKey,
                skipDefaultResolvers, skipDefaultCallbacks, placeholderReplacement, baselineOnMigrate,
                outOfOrder, ignoreMissingMigrations, ignoreIgnoredMigrations, ignorePendingMigrations,
                ignoreFutureMigrations, validateOnMigrate, cleanOnValidationError, cleanDisabled,
                allowMixedMigrations, mixed, group, installedBy,
                dryRun, stream, batch, oracleSqlPlus, connectRetries);
    }
}