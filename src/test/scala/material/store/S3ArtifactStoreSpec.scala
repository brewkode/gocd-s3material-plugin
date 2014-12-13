package material.store

import org.scalatest.FlatSpec
import java.io.File
import org.scalatest.matchers.ShouldMatchers._

class S3ArtifactStoreSpec extends FlatSpec {
  object FileHelperUtil extends FileHelper

  "S3ArtifactStore" should "get file from remote file path to local file path" in {
    val store = S3ArtifactStore()
    store.get(this.getClass.getResource("/remoteGetFile").getPath, "/tmp/localGetFile")
    FileHelperUtil.exists("/tmp/localGetFile", store.conf) should be (true)
    new File("/tmp/localGetFile").delete()
  }
}
