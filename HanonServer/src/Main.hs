{-# LANGUAGE OverloadedStrings #-}
module Main where

import Control.Applicative
import Snap.Core
import Snap.Util.FileServe
import Snap.Http.Server

import System.Directory
import qualified Data.ByteString.Char8 as BS
import Control.Monad.IO.Class
import Data.List

main :: IO ()
main = do
  quickHttpServe site

site :: Snap ()
site = do
  directory <- liftIO pieces
  ifTop (writeBS (packed directory)) <|> dir "res" (serveDirectory "res")

pieces = getDirectoryContents "./res"

packed :: [String] -> BS.ByteString
packed =  BS.pack . concat . commaSeparate . filter notStartingWithDot

commaSeparate = intersperse ","

notStartingWithDot :: String -> Bool
notStartingWithDot = not . isPrefixOf "."
