(ns scratch
  (:require
    [clojure.edn :as edn]
    [clojure.repl :refer :all]
    [clojure.test :refer :all]
    [clojure.java.io :as io]
    [twitter.oauth :refer :all]
    [twitter.callbacks :refer :all]
    [twitter.callbacks.handlers :refer :all]
    [twitter.api.restful :refer :all]
    [tweet.core :refer :all]))

;(friendships-show :oauth-creds my-creds
;                  :params {:target-screen-name "everett_toews"})

;(users-show :oauth-creds my-creds :params {:screen-name "everett_toews"})

;(statuses-update :oauth-creds my-creds :params {:status "Tweeting with #clojure from inside Light Table. Neat."})

(statuses-home-timeline :oauth-creds my-creds :params {:count 3})
