<!-- Modal -->
<div class="modal fade" id="addWordModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="row">
                <div class="col-md-1">
                </div>
                <div class="col-md-10">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="modalLabel">Add new word</h4>
                    </div>
                    <div class="modal-body">
                        <form action="/vocky/word/add" id="modalForm" method="post">
                            <div class="form-group">
                                <input type="text" class="form-control" id="id" name="id" value="0" style="display:none">
                                <label for="word">New word</label>
                                <input required type="text" class="form-control" id="word" name="word" placeholder="word">
                            </div>
                            <div class="form-group">
                                <label for="translation">Translation</label>
                                <input required type="text" class="form-control" id="translation" name="translation" placeholder="translation">
                            </div>
                            <div class="form-group">
                                <label for="category">Category</label>
                                <input required type="text" class="form-control" id="category" name="category" placeholder="category">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" id="addAsWeekWord" name="addAsWeekWord" >Add word to week list?
                                </label>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <input type="submit" id="submitModal" class="btn btn-primary" value="Add word"/>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-1">
                </div>
            </div>
        </div>
    </div>
</div>