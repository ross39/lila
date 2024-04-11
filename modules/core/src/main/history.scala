package lila.core
package history

import lila.core.rating.Perf
import lila.core.rating.data.IntRating
import lila.core.perf.PerfKey
import lila.core.user.User
import lila.core.user.WithPerf
import lila.core.userId.UserId
import scalalib.model.Days

trait HistoryApi:
  def addPuzzle(user: User, completedAt: Instant, perf: Perf): Funit
  def progresses(users: List[WithPerf], perfKey: PerfKey, days: Days): Fu[List[PairOf[IntRating]]]
  def lastWeekTopRating(user: UserId, perf: PerfKey): Fu[IntRating]
  def setPerfRating(user: User, perf: PerfKey, rating: IntRating): Funit