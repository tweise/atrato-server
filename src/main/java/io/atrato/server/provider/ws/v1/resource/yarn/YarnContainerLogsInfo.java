/**
 * Copyright (c) 2017 Atrato, Inc. ALL Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.atrato.server.provider.ws.v1.resource.yarn;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import io.atrato.server.provider.ws.v1.resource.ContainerLogInfo;
import io.atrato.server.provider.ws.v1.resource.ContainerLogsInfo;

/**
 * Created by david on 1/7/17.
 */
public class YarnContainerLogsInfo implements ContainerLogsInfo
{
  private final Map<String, ContainerLogInfo> logs = new TreeMap<>();

  public void addLog(String name, long size)
  {
    logs.put(name, new YarnContainerLogInfo(name, size));
  }

  @Override
  public Collection<ContainerLogInfo> getLogs()
  {
    return logs.values();
  }

  @Override
  public ContainerLogInfo getLog(String name)
  {
    return logs.get(name);
  }
}
