package material.store

import org.scalatest.FlatSpec
import java.io.File
import org.scalatest.matchers.ShouldMatchers._
import org.mockito.Mockito._
import com.amazonaws.services.s3.AmazonS3Client
import org.mockito.Matchers._
import com.amazonaws.services.s3.model.{ObjectMetadata, GetObjectRequest}

class S3ArtifactStoreSpec extends FlatSpec {
  object StoreHelperUtil$ extends StoreHelper

  "S3ArtifactStore" should "get file from remote file path to local file path" in {
    val s3Client = mock(classOf[AmazonS3Client])
    val objectMetadata = new ObjectMetadata()
    objectMetadata.setContentMD5("MD5")
    when(s3Client.getObject(anyObject[GetObjectRequest](), anyObject[File]())).thenReturn(objectMetadata)
    val store = S3ArtifactStoreWithS3Client(s3Client, "indix-bucket")
    store.get("remoteFile", "localFile").asInstanceOf[CopySuccess].md5 should be("MD5")
  }
}
