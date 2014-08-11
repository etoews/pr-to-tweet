(ns scratch
  (:use [clojure.pprint :only (pprint)])
  (:require
    [twitter.oauth :refer :all]
    [twitter.api.restful :refer :all]
    [tweet.core :refer :all]
    [tentacles.repos :as repos]
    [github.core :refer :all]))

;; Twitter

(def twitter-config (load-twitter-config))

(pprint twitter-config)

(def twitter-creds
  (make-oauth-creds (:app-consumer-key twitter-config)
                    (:app-consumer-secret twitter-config)
                    (:user-access-token twitter-config)
                    (:user-access-token-secret twitter-config)))

;;(friendships-show :oauth-creds twitter-creds
;;                  :params {:target-screen-name (:screen-name twitter-config)})

;;(users-show :oauth-creds twitter-creds :params {:screen-name (:screen-name twitter-config)})

;;(statuses-update :oauth-creds twitter-creds :params {:status "Tweeting with #clojure from inside Light Table. Neat."})

(def tweets (statuses-home-timeline :oauth-creds twitter-creds :params {:count 3}))

(pprint tweets)

(pprint (map :text (:body tweets)))

;; GitHub

(def github-config (load-github-config))

(def github-creds (str (:username github-config) ":" (:password github-config)))

(repos/repos {:auth github-creds})

(pprint (map :name repos))
