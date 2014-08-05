(ns tweet.core-test
  (:require [clojure.test :refer :all])

(deftest test-load-twitter-config-default
  (is (thrown? java.io.FileNotFoundException (load-twitter-config))))

(deftest test-load-twitter-config
  (def twitter-config (load-twitter-config "resources/twitter.edn.template"))
  (is (= "my-app-consumer-key" (:app-consumer-key twitter-config)))
  (is (= "my-app-consumer-secret" (:app-consumer-secret twitter-config)))
  (is (= "my-user-access-token" (:user-access-token twitter-config)))
  (is (= "my-user-access-token-secret" (:user-access-token-secret twitter-config))))
