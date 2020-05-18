/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.zonky.test.db.provider;

public class MissingDatabaseProviderException extends IllegalStateException {

    private final DatabaseDescriptor descriptor;

    public MissingDatabaseProviderException(DatabaseDescriptor descriptor) {
        this.descriptor = descriptor;
    }

    public DatabaseDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public String getMessage() {
        return String.format("Missing database provider for descriptor: %s", descriptor);
    }
}