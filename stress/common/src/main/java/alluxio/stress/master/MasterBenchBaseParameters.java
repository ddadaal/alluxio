/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.stress.master;

import alluxio.stress.Parameters;
import alluxio.stress.common.FileSystemParameters;

import com.beust.jcommander.Parameter;

/**
 * This holds all the parameters shared by the MasterBench and MasterBatchTask.
 */
public class MasterBenchBaseParameters extends FileSystemParameters {
  /** The stop count value that is invalid. */
  public static final int STOP_COUNT_INVALID = -1;

  @Parameter(names = {"--clients"}, description = "the number of fs client instances to use")
  public int mClients = 1;

  @Parameter(names = {"--threads"}, description = "the number of concurrent threads to use")
  public int mThreads = 256;

  @Parameter(names = {"--warmup"},
      description = "The length of time to warmup before recording measurements. (1m, 10m, 60s, "
          + "10000ms, etc.)")
  public String mWarmup = "30s";

  @Parameter(names = {"--base"},
      description = "The base directory path URI to perform operations in")
  @Parameters.PathDescription(aliasFieldName = "mBaseAlias")
  public String mBasePath = "alluxio:///stress-master-base";

  @Parameter(names = {"--stop-count"},
      description = "The benchmark will stop after this number of paths. If -1, it is not used and "
          + "the benchmark will stop after the duration. If this is used, duration will be "
          + "ignored. This is typically used for creating files in preparation for another "
          + "benchmark, since the results may not be reliable with a non-duration-based "
          + "termination condition.")
  public int mStopCount = STOP_COUNT_INVALID;

  @Parameter(names = {"--create-file-size"},
      description = "The size of a file for the Create op, allowed to be 0. (0, 1m, 2k, 8k, etc.)")
  public String mCreateFileSize = "0";
}
