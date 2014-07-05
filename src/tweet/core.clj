(ns tweet.core
  (:require
    [clojure.edn :as edn]
    [clojure.java.io :as io]
    [twitter.oauth :refer :all]
    [twitter.callbacks :refer :all]
    [twitter.callbacks.handlers :refer :all]
    [twitter.api.restful :refer :all])
  (:import
    (twitter.callbacks.protocols SyncSingleCallback)))

(def creds
  (->> "twitter.edn"
    io/resource
    slurp
    edn/read-string))

(def my-creds
  (make-oauth-creds (:app-consumer-key creds)
                    (:app-consumer-secret creds)
                    (:user-access-token creds)
                    (:user-access-token-secret creds)))
