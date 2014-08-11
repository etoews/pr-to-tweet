(ns scratch
  (:use [clojure.pprint :only (pprint)])
  (:require
    [twitter.oauth :refer :all]
    [twitter.api.restful :refer :all]
    [tweet.core :refer :all]))

(def twitter-config (load-twitter-config "resources/twitter.edn"))

(pprint twitter-config)

(def twitter-creds
  (make-oauth-creds (:app-consumer-key twitter-config)
                    (:app-consumer-secret twitter-config)
                    (:user-access-token twitter-config)
                    (:user-access-token-secret twitter-config)))

;;(friendships-show :oauth-creds my-creds
;;                  :params {:target-screen-name "everett_toews"})

;;(users-show :oauth-creds twitter-creds :params {:screen-name "everett_toews"})

;;(statuses-update :oauth-creds my-creds :params {:status "Tweeting with #clojure from inside Light Table. Neat."})

(def tweets (statuses-home-timeline :oauth-creds twitter-creds :params {:count 3}))

(pprint tweets)

()
