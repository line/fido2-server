/*
 * Copyright 2024 LY Corporation
 *
 * LY Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.linecorp.line.auth.fido.fido2.server.attestation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linecorp.line.auth.fido.fido2.server.model.AttestationStatementFormatIdentifier;

@Service
public class AttestationVerifierFactory {
    private final Map<AttestationStatementFormatIdentifier, AttestationVerifier> verifierMap;

    @Autowired
    public AttestationVerifierFactory(List<AttestationVerifier> verifierList) {
        verifierMap = verifierList.stream()
                .collect(Collectors.toMap(AttestationVerifier::getIdentifier, Function.identity()));
    }

    public AttestationVerifier getVerifier(AttestationStatementFormatIdentifier identifier) {
        return verifierMap.get(identifier);
    }
}
