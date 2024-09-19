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

package com.linecorp.line.auth.fido.fido2.common.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.linecorp.line.auth.fido.fido2.common.AttestationConveyancePreference;
import com.linecorp.line.auth.fido.fido2.common.AuthenticatorSelectionCriteria;
import com.linecorp.line.auth.fido.fido2.common.PublicKeyCredentialParameters;
import com.linecorp.line.auth.fido.fido2.common.PublicKeyCredentialRpEntity;
import com.linecorp.line.auth.fido.fido2.common.extension.AuthenticationExtensionsClientInputs;

import lombok.*;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@ToString
public class RegOptionResponse implements ServerAPIResult {
    private ServerResponse serverResponse;
    private PublicKeyCredentialRpEntity rp;
    private ServerPublicKeyCredentialUserEntity user;
    private String challenge;   // base64 url encoded
    private List<PublicKeyCredentialParameters> pubKeyCredParams;
    private Long timeout;
    private List<ServerPublicKeyCredentialDescriptor> excludeCredentials;
    private AuthenticatorSelectionCriteria authenticatorSelection;
    private AttestationConveyancePreference attestation;
    private String sessionId;
    // extension
    private AuthenticationExtensionsClientInputs extensions;
}
