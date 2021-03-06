package com.acmedcare.framework.newim.storage.api;

import com.acmedcare.framework.newim.Topic;
import com.acmedcare.framework.newim.Topic.TopicSubscribe;
import java.util.List;

/**
 * Topic Repository
 *
 * @author <a href="mailto:iskp.me@gmail.com">Elve.Xu</a>
 * @version ${project.version} - 2018-12-14.
 */
public interface TopicRepository {

  /**
   * Save new topics
   *
   * @param topics topics instance
   * @see Topic
   */
  void save(Topic[] topics);

  /**
   * Query All Topics
   *
   * @return topic list
   * @param namespace namespace
   * @param topicTag
   */
  List<Topic> queryTopics(String namespace, String topicTag);

  /**
   * Query Topics By ids
   *
   * @param topicIds topic ids
   * @return topic list
   */
  List<Topic> queryTopics(Long[] topicIds);

  /**
   * save topic subscribe mappings
   *
   * @param subscribes list
   */
  void saveSubscribes(TopicSubscribe... subscribes);

  /**
   * Remove topic subscribe mappings
   *
   * @param namespace namespace
   * @param passportId passport id
   * @param topicIds topic ids
   */
  void removeSubscribes(String namespace, String passportId, String[] topicIds);

  /**
   * Query Topic Detail
   *
   * @param namespace namespace
   * @param topicId topic id
   * @return a instance of {@link Topic}
   */
  Topic queryTopicDetail(String namespace, Long topicId);

  /**
   * Query Topic Subscribe Passports
   *
   * @param namespace namespace
   * @param topicId topic id
   * @return list mapping
   */
  List<TopicSubscribe> queryTopicSubscribes(String namespace, Long topicId);

  /**
   * Remove topic
   *
   * @param namespace name
   * @param topicId topic id
   */
  void removeTopic(String namespace, Long topicId);
}
