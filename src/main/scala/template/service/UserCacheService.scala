package template.service

import javax.inject.Inject

import com.twitter.util.Future
import template.domain.{UserID, UserInfo}
import template.repository.CacheRepository

import scala.collection.mutable

/**
  * Created by SangDang on 9/16/16.
  */
trait UserCacheService{
  def addUser(id: UserID, info: UserInfo)
  def getUser(id: UserID): Future[UserInfo]
}

class UserCacheServiceImpl @Inject()(cacheRepository: CacheRepository[UserID, UserInfo]) extends UserCacheService {

  override def addUser(id: UserID, info: UserInfo): Unit = {
    Future {
      cacheRepository.put(id, info)
    }
  }

  override def getUser(id: UserID): Future[UserInfo] = {
    Future {
      cacheRepository.get(id)
    }
  }
}
